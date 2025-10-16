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

     public List<Order> splitOrderToDiscountSet() {
          final List<Order> finalOrder=new ArrayList<>();
          final Collection<Book> booksCopy = new ArrayList<>(books);
          while (!booksCopy.isEmpty()) {
               var bookSet = new HashSet<>(booksCopy);
               bookSet.forEach(booksCopy::remove);
               finalOrder.add(new Order(bookSet));
          }
          return finalOrder;
     }

     public double applyDiscount() {
          double price =this.getBooks().stream()
                  .map(Book::getPrice)
                  .reduce(0d, Double::sum);
          if (this.containHog()){
               return price-(price*0.25);
          }
          if (this.containsNDifferentBook(4)){
               return price-(price*.2);
          }
          if (this.containsNDifferentBook(3)){
               return price-(price*.1);
          }
          if (this.containsNDifferentBook(2))
               return price-(price*0.05);
          return price;
     }

     public boolean containsNDifferentBook(int i) {
          return new HashSet<>(books).size() >= i;
     }

     public boolean containHog() {
          return books.containsAll(BookEnum.getBooks());
     }
}
