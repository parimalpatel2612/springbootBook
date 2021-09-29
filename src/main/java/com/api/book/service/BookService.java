package com.api.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
//	private static List<Book> allBooks = new ArrayList<Book>();
	
//	static {
//		allBooks.add(new Book(1, "java", "James"));
//		allBooks.add(new Book(2, ".net", "JH"));
//		allBooks.add(new Book(3, "C#", "LM"));
//		allBooks.add(new Book(4, "DBS", "NS"));
//		allBooks.add(new Book(5, "CNa", "James"));
//		allBooks.add(new Book(6, "Graphics", "DM"));
//		allBooks.add(new Book(7, "TOC", "peter"));
//	}
	
	
	public List<Book> getAllBook(){
//		return allBooks;
		return (List<Book>) bookRepository.findAll();
		
	}
	
	public Book getBookById(int id) {
//		return allBooks.stream().filter(book -> book.getId() == id).findFirst().get();
		return bookRepository.findById(id);
	}
	
	public Book addBook(Book book) {
//		 allBooks.add(book);
//		 return book;
		bookRepository.save(book);
		return book;
	}
	
	public void deleteBook(int id) {
//		Book b = getBookById(id);
//		allBooks.remove(b);
		
		bookRepository.deleteById(id);
	}
	
	public Book updateBook(int id, Book book) {
//		Book b = getBookById(id);
//		b.setTitle(book.getTitle());
//		b.setAuthor(book.getAuthor());
//		return b;
		book.setId(id);
		return bookRepository.save(book);
	}
}
