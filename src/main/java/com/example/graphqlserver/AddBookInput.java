package com.example.graphqlserver;

public record AddBookInput(String id, String name, int pageCount, String authorId) {

}
