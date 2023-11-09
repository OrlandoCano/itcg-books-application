package com.itcg.books_application.service;

import com.itcg.books_application.model.dto.BookDto;
import java.util.List;

public interface BookService {
  BookDto saveBook(BookDto book);

  BookDto loadBookById(Long id);

  void deleteBookById(Long id);

  List<BookDto> loadAllBooks();
}
