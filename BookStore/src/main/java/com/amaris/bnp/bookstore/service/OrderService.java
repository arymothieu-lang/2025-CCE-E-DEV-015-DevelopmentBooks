package com.amaris.bnp.bookstore.service;

import com.amaris.bnp.bookstore.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public double getPrice(Order order){
        Double acc = 0d;
        for (Order order1 : order.splitOrderToDiscountSet()) {
            Double applyDiscount = order1.applyDiscount();
            acc = acc + applyDiscount;
        }
        return acc;
    }


}
