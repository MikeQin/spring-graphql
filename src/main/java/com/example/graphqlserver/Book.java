package com.example.graphqlserver;

import java.util.ArrayList;
import java.util.List;

public record Book (String id, String name, int pageCount, String authorId) {

//    private static List<Book> books = Arrays.asList(
//            new Book("book-1", "Effective Java", 416, "author-1"),
//            new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
//            new Book("book-3", "Down Under", 436, "author-3")
//    );
    
    private static List<Book> books = new ArrayList<>();
    static {
        Book book1 = new Book("book-1", "Effective Java", 416, "author-1");
        Book book2 = new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2");
        Book book3 = new Book("book-3", "Down Under", 436, "author-3");
        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    public static Book getById(String id) {
        return books.stream()
				.filter(book -> book.id().equals(id))
				.findFirst()
				.orElse(null);
    }
    
    public static List<Book> getAll() {
        return books;
    }
}
