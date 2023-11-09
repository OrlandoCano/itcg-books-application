package com.itcg.books_application.controller;

import com.itcg.books_application.model.dto.BookDto;
import com.itcg.books_application.model.request.BookRequest;
import com.itcg.books_application.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/books")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @GetMapping
  public ResponseEntity<List<BookDto>> loadAllBooks() {
    return new ResponseEntity<>(bookService.loadAllBooks(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDto> loadBooks(@PathVariable Long id) {
    return new ResponseEntity<>(bookService.loadBookById(id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.deleteBookById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity<BookDto> createBook(@RequestBody BookRequest bookRequest) {
    return new ResponseEntity<>(
        bookService.saveBook(
            BookDto.builder()
                .id(bookRequest.getId())
                .isbn(bookRequest.getIsbn())
                .name(bookRequest.getName())
                .author(bookRequest.getAuthor())
                .releaseDate(bookRequest.getReleaseDate())
                .editorial(bookRequest.getEditorial())
                .build()),
        HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<BookDto> saveBook(@RequestBody BookRequest bookRequest) {
    return new ResponseEntity<>(
        bookService.saveBook(
            BookDto.builder()
                .id(bookRequest.getId())
                .isbn(bookRequest.getIsbn())
                .name(bookRequest.getName())
                .author(bookRequest.getAuthor())
                .releaseDate(bookRequest.getReleaseDate())
                .editorial(bookRequest.getEditorial())
                .build()),
        HttpStatus.CREATED);
  }
}
