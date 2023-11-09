package com.itcg.books_application.repository;

import com.itcg.books_application.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
