package creational;

import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    @Override
    public void add(Book b) {
        append(b);
    }

    public void export(PrintStream stream) {
        stream.print(getMetadataString());
    }

    public abstract String getMetadataString();

    public abstract BookMetadataExporter append(Book b);
}
