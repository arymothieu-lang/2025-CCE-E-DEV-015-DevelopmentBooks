package com.amaris.bnp.bookstore;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Book {
    String title;
    String author;
    Integer year;
    Double price;


}
