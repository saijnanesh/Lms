package com.springboot.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lms.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
