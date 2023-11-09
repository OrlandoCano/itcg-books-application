package com.itcg.books_application.model.dto;

import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
@Jacksonized
public class BookDto {
  Long id;
  String isbn;
  String name;
  String author;
  Date releaseDate;
  String editorial;
}
