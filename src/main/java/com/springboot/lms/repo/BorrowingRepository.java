package com.springboot.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lms.model.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

}
