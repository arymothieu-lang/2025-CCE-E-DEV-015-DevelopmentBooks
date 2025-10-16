package com.amaris.bnp.bookstore.service;

import com.amaris.bnp.bookstore.Book;
import com.amaris.bnp.bookstore.BookEnum;
import com.amaris.bnp.bookstore.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = OrderService.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void shouldReturn0forAnEmptyOrder(){
        var price = orderService.getPrice(new Order());
        assertEquals(0,price);

    }

    @ParameterizedTest
    @EnumSource(value = BookEnum.class)
    public void shouldReturn50for1Book(BookEnum book){
        final Order order=new Order(book.getBook());
        final var result=orderService.getPrice(order);
        assertEquals(50f,result);
    }

    @Test
    public void shouldApply5PercentDiscountOnFinalPriceWhen2DifferentBookOrdered(){
        final var book1 = BookEnum.CLEAN_CODE.getBook();
        final var book2 = BookEnum.CLEAN_ARCHITECTURE.getBook();
        final var order = new Order(book1, book2);
        var price = orderService.getPrice(order);
        assertEquals(95,price);
    }

    @Test
    public void shouldApply10PercentDiscountOnFinalPriceWhen3DifferentBookOrdered(){
        final var book1 = BookEnum.CLEAN_CODE.getBook();
        final var book2 = BookEnum.CLEAN_ARCHITECTURE.getBook();
        final var book3 = BookEnum.TEST_DRIVEN_DEVELOPMENT.getBook();
        final var order = new Order(book1, book2,book3);
        var price = orderService.getPrice(order);
        assertEquals(135,price);
    }

    @Test
    public void shouldApply20PercentDiscountOnFinalPriceWhen4DifferentBookOrdered(){
        final var book1 = BookEnum.CLEAN_CODE.getBook();
        final var book2 = BookEnum.CLEAN_ARCHITECTURE.getBook();
        final var book3 = BookEnum.TEST_DRIVEN_DEVELOPMENT.getBook();
        final var book4 = BookEnum.THE_CLEAN_CODER.getBook();
        final var order = new Order(book1, book2,book3,book4);
        var price = orderService.getPrice(order);
        assertEquals(160,price);
    }

    @Test
    public void shouldApply25percentDiscountOnFinalPriceForTheHoleHog(){
        List<Book> hogBooks = BookEnum.getBooks();
        final var order=new Order(hogBooks);
        final var price = orderService.getPrice(order);
        assertEquals(187.5,price);

    }


}
