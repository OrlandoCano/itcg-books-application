package com.itcg.books_application.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BookRequest {
  private Long id;
  private String isbn;
  private String name;
  private String author;
  private Date releaseDate = new Date();
  private String editorial;
}
