package com.amaris.bnp.bookstore;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
@Getter
public class Order {
     private List<Book> books;

     public Order(){
          books= Collections.emptyList();
     }

     public Order(Book book) {
          books=List.of(book);
     }

     public Double getPrice() {
          return books.stream()
                  .map(Book::getPrice)
                  .reduce(Double::sum)
                  .orElse(0d);

     }
}
