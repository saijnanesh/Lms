package com.springboot.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.lms.model.Book;
import com.springboot.lms.repo.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepo;

	@RequestMapping("/books")
	public String listOfBooks(Model model) {
		List<Book> bookList = bookRepo.findAll();
		model.addAttribute("books", bookList);
		return "books";
	}

	@RequestMapping("/book/new")
	public String showCreateForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "create_book";
	}

	@PostMapping("/savebook")
	public String saveBook(Book book) {
		bookRepo.save(book);
		return "redirect:/books";
	}
}
