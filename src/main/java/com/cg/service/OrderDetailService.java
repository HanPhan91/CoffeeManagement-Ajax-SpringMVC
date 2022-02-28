package com.cg.service;

import com.cg.model.Order;
import com.cg.model.OrderDetail;

import java.util.List;

public interface OrderDetailService extends IGeneralService<OrderDetail> {
    List<OrderDetail> findByOrder(Order order);
}
