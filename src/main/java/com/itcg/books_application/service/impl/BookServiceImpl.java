package com.itcg.books_application.service.impl;

import com.itcg.books_application.exception.BookNotFoundException;
import com.itcg.books_application.model.dto.BookDto;
import com.itcg.books_application.model.entity.Book;
import com.itcg.books_application.repository.BookRepository;
import com.itcg.books_application.service.BookService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
  private final BookRepository repository;

  @Override
  public BookDto saveBook(BookDto book) {
    Book savedBook =
        repository.save(
            new Book(
                book.getId(),
                book.getIsbn(),
                book.getName(),
                book.getAuthor(),
                book.getReleaseDate() == null ? new Date() : book.getReleaseDate(),
                book.getEditorial()));
    return BookDto.builder()
        .id(savedBook.getId())
        .isbn(savedBook.getISBN())
        .name(savedBook.getName())
        .author(savedBook.getAuthor())
        .releaseDate(savedBook.getReleaseDate())
        .editorial(savedBook.getEditorial())
        .build();
  }

  @Override
  public BookDto loadBookById(Long id) {
    Book book =
        repository
            .findById(id)
            .orElseThrow(
                () -> new BookNotFoundException(String.format("Book with id=%s not found", id)));
    return BookDto.builder()
        .id(book.getId())
        .isbn(book.getISBN())
        .name(book.getName())
        .author(book.getAuthor())
        .releaseDate(book.getReleaseDate())
        .editorial(book.getEditorial())
        .build();
  }

  @Override
  public void deleteBookById(Long id) {
    repository.deleteById(id);
  }

  @Override
  public List<BookDto> loadAllBooks() {
    return repository.findAll().stream()
        .map(
            book ->
                BookDto.builder()
                    .id(book.getId())
                    .isbn(book.getISBN())
                    .name(book.getName())
                    .author(book.getAuthor())
                    .releaseDate(book.getReleaseDate())
                    .editorial(book.getEditorial())
                    .build())
        .collect(Collectors.toList());
  }
}
