package com.cg.service;

import com.cg.model.Order;
import com.cg.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order getById(Long id) {
        return null;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public String incomeToday() {
        return orderRepository.incomeToday();
    }

    @Override
    public String incomeToMonth() {
        return orderRepository.incomeToMonth();
    }
}
