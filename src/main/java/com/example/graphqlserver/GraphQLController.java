package com.example.graphqlserver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

/**
 * http://localhost:8080/graphiql?path=/graphql
 * 
 * Mutation Reference: https://github.com/techdozo/graphql-spring-mutation/tree/master
 * https://techdozo.dev/spring-for-graphql-mutation/
 */
@Controller
public class GraphQLController {
	@QueryMapping
	public Book bookById(@Argument(name = "id") String id) {
		return Book.getById(id);
	}

	@QueryMapping
	public List<Book> allBooks() {
		return Book.getAll();
	}
	
	@QueryMapping(name = "authorById")
	public Author authorById(@Argument(name = "id") String id) {
		return Author.getById(id);
	}
	
	@QueryMapping
	public List<Author> allAuthors() {
		return Author.getAll();
	}	

	@MutationMapping(name = "addBook")
	public Book addBook(@Argument(name = "book") AddBookInput book) {
		Book newBook = new Book(book.id(), book.name(), book.pageCount(), book.authorId());
		Book.getAll().add(newBook);
		return newBook;
	}

	// Relation mapping
	@SchemaMapping
	public Author author(Book book) {
		return Author.getById(book.authorId());
	}
}