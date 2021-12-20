package aop.aspects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("${book.name}")
    String Name;

    @Value("${book.author}")
    private String author;

    @Value("1826")
    private int yearOfPublication;

    public String getName() {
        return Name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
