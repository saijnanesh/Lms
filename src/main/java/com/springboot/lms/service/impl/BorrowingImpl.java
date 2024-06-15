package com.springboot.lms.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.lms.model.Borrowing;
import com.springboot.lms.repo.BookRepository;
import com.springboot.lms.repo.BorrowingRepository;
import com.springboot.lms.repo.MemberRepository;
import com.springboot.lms.service.BorrowingService;

@Service
public class BorrowingImpl implements BorrowingService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BorrowingRepository borrowingRepository;

	@Override
	public Borrowing borrowBook(Long bookId, Long memberId) {
		Borrowing borrow = new Borrowing();
		borrow.setBook(bookRepository.findById(bookId).get());
		borrow.setMember(memberRepository.findById(memberId).get());
		borrow.setBorrowerDate(new Date());
		return borrowingRepository.save(borrow);
	}

	@Override
	public Borrowing returnBook(Long borrowingId) {
		Borrowing borrow = new Borrowing();
		borrow = borrowingRepository.findById(borrowingId).get();
		borrow.setReturnDate(new Date());
		return borrowingRepository.save(borrow);
	}

}
