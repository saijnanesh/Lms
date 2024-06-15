package com.springboot.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.lms.model.Book;
import com.springboot.lms.model.Member;
import com.springboot.lms.repo.BookRepository;
import com.springboot.lms.repo.BorrowingRepository;
import com.springboot.lms.repo.MemberRepository;
import com.springboot.lms.service.BorrowingService;

@Controller
public class BorrowingController {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BorrowingRepository borrowingRepository;

	@Autowired
	private BorrowingService service;

	@GetMapping("/borrow")
	public String showBorrowForm(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("members", memberRepository.findAll());
		return "borrow_book";
	}

	@PostMapping("/borrow/book")
	public String borrowBook(@RequestParam Long bookId,@RequestParam Long memberId, Model model) {
		service.borrowBook(bookId, memberId);
		model.addAttribute("message", "Book Added SuccessFully");
		return "borrow_success";
	}
	
	@GetMapping("/return")
	public String showBorrowedBooks(Model model) {
		model.addAttribute("borrowers",borrowingRepository.findAll());
		return "return_book";
	}
	
	@PostMapping("/return/book")
	public String returnBook(@RequestParam Long id,Model model) {
		service.returnBook(id);
		model.addAttribute("message","Book Returned SuccesFully");
		return "return_success";
	}
	
}
