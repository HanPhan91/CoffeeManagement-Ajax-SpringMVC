package com.cg.service;

import com.cg.model.Order;
import com.cg.model.OrderDetail;
import com.cg.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderDetailImpl implements OrderDetailService{

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public OrderDetail getById(Long id) {
        return null;
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<OrderDetail> findByOrder(Order order) {
        return orderDetailRepository.findByOrder(order);
    }
}
