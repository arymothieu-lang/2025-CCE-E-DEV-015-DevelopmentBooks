package com.amaris.bnp.bookstore;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
public class Order {
     private List<Book> books;

     public Order(){
          books= Collections.emptyList();
     }

     public Order(Collection<Book> books) {
          this.books=new ArrayList<>(books);
     }

     public Order(Book ... books) {
          this.books=List.of(books);
     }

     public int getAvailableBookSize() {
          return (int) books.stream().distinct().count();
     }
}
