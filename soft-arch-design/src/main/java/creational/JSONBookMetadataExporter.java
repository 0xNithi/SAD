package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONBookMetadataExporter extends BookMetadataExporter {

    private JSONObject document = new JSONObject();
    private JSONArray books = new JSONArray();

    public JSONBookMetadataExporter() {
        reset();
    }

    public BookMetadataExporter reset() {
        document = new JSONObject();
        books = new JSONArray();
        document.put("Books", books);
        return null;
    }

    public BookMetadataExporter append(Book b) {
        JSONObject book = new JSONObject();
        JSONArray authors = new JSONArray();
        for (String author : b.getAuthors()) {
            authors.add(author);
        }
        book.put("ISBN", b.getISBN());
        book.put("Authors", authors);
        book.put("Title", b.getTitle());
        book.put("Publisher", b.getPublisher());
        books.add(book);
        document.put("Books", books);
        return this;
    }

    public String getMetadataString() {
        return document.toJSONString();
    }
}
