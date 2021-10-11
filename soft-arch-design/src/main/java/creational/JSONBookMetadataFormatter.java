package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject document = new JSONObject();
    private JSONArray books = new JSONArray();

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        document = new JSONObject();
        books = new JSONArray();
        document.put("Books", books);
        return null;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
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

    @Override
    public String getMetadataString() {
        return document.toJSONString();
    }
}
