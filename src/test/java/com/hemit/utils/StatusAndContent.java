package java.com.hemit.utils;

public class StatusAndContent<T> {
    public int statusCode;
    public T content;

    public StatusAndContent(int statusCode, T content) {
        this.statusCode = statusCode;
        this.content = content;
    }
}