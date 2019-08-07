package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookRepository;

//@CrossOrigin(value = "http://localhost:4200")
@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/")
	public String message() {
		return "welcome..!";
	}

	@PostMapping("/addBook")
	public Book saveBook(@RequestBody Book book) {
		System.out.println(book.getBookName());
		System.out.println(book.getAuthorName());
		bookRepository.insert(book);
		return book;
	}

	@GetMapping("/findAllbooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/findAllbooks/{id}")
	public Optional<Book> getBook(@PathVariable String id) {
		return bookRepository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable String id) {
		System.out.println(id);
		bookRepository.deleteById(id);
		return "Book deleted with id: " + id;
	}
	
	 @PutMapping("/update/{id}")
	 public Book updateBook(@PathVariable String id, @RequestBody Book book)
	 {			
		System.out.println(id);
		book.setId(id);
		bookRepository.save(book);			
		return book;
		 
	 }
	 

}
