package creational;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class CSVBookMetadataExporter extends BookMetadataExporter {

    private StringWriter writer;
    private CSVPrinter csvPrinter;

    public CSVBookMetadataExporter() {
        this.reset();
    }

    public BookMetadataExporter reset() {
        writer = new StringWriter();
        try {
            csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            Stream<String> headers = Arrays.stream(Book.Metadata.values()).map(Book.Metadata::getValue);
            csvPrinter.printRecord(headers.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BookMetadataExporter append(Book b) {
        String authors = String.join("|", b.getAuthors());
        try {
            csvPrinter.printRecord(b.getISBN(), b.getTitle(), b.getPublisher(), authors);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getMetadataString() {
        return writer.toString();
    }
}
