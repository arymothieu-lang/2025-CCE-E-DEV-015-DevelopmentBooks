package com.amaris.bnp.bookstore;

import lombok.Getter;

import java.util.List;
@Getter
public class Order {
     private List<Book> books;

     public Order(Book book) {
          books=List.of(book);
     }
}
