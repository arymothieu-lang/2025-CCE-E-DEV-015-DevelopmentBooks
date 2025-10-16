package com.amaris.bnp.bookstore.service;

import com.amaris.bnp.bookstore.MatrixUtils;
import com.amaris.bnp.bookstore.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public double getPrice(Order order){
        return MatrixUtils.getMinPrice(order)*50;
    }


}
