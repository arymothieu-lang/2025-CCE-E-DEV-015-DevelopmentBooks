package com.amaris.bnp.bookstore;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
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

     public Double getPrice() {

          double discount=0;
          if (containHog()){
               discount=.25;
          }
          if (containsNDifferentBook(4)){
               discount=.2;
          }
          if (containsNDifferentBook(3)){
               discount=.1;
          }
          if (containsNDifferentBook(2)){
               discount=.05;
          }
          return (1-discount)*books.stream()
                  .map(Book::getPrice)
                  .reduce(Double::sum)
                  .orElse(0d);

     }

     public boolean containsNDifferentBook(int i) {
          return new HashSet<>(books).size() >= i;
     }

     public boolean containHog() {
          return books.containsAll(BookEnum.getBooks());
     }
}
