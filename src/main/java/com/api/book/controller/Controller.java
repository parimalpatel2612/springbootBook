package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.service.BookService;

@RestController
public class Controller {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
//		Book book = new Book(1, "Java", "Goslin");
		List<Book> lstOfBook = bookService.getAllBook();
		
		if(lstOfBook.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(lstOfBook));
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
//		Book book = new Book(1, "Java", "Goslin");
		return bookService.getBookById(id);
	}
	
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
//		Book book = new Book(1, "Java", "Goslin");
		return bookService.addBook(book);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") int id) {
//		Book book = new Book(1, "Java", "Goslin");
		bookService.deleteBook(id);
	}
	
	@PutMapping("/book/{id}")
	public Book deleteBook(@RequestBody Book book ,@PathVariable("id") int id) {
//		Book book = new Book(1, "Java", "Goslin");
		return bookService.updateBook(id, book);
	}
}
