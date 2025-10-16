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

     public Order(Book ... books) {
          this.books=List.of(books);
     }

     public Double getPrice() {
          double discount=0;
          if (books.size()==3){
               discount=.1;
          }
          if (books.size()==2){
               discount=.05;
          }
          return (1-discount)*books.stream()
                  .map(Book::getPrice)
                  .reduce(Double::sum)
                  .orElse(0d);

     }
}
