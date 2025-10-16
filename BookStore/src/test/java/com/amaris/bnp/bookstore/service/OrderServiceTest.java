package com.amaris.bnp.bookstore.service;

import com.amaris.bnp.bookstore.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
