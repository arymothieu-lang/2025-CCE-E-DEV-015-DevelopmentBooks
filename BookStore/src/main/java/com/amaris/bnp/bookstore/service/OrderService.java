package com.amaris.bnp.bookstore.service;

import com.amaris.bnp.bookstore.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public Double getPrice(Order order) {
        return order.getPrice();

    }
}
