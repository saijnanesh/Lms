package com.springboot.lms.service;

import com.springboot.lms.model.Borrowing;

public interface BorrowingService {
	
	Borrowing borrowBook(Long bookId, Long memberId);
	Borrowing returnBook(Long borrowingId);
}
