package com.cg.service;

import com.cg.model.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


public interface OrderService extends IGeneralService<Order> {
    public String incomeToday();
    public String incomeToMonth();
}
