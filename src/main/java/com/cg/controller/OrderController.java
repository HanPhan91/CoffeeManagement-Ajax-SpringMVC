package com.cg.controller;

import com.cg.model.CatalogDrink;
import com.cg.model.Drink;
import com.cg.model.Order;
import com.cg.service.DrinkService;
import com.cg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    DrinkService drinkService;

    @Autowired
    OrderService orderService;

    @GetMapping
    public ModelAndView createOrder() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order/createOrder");
        List<Drink> drinks = drinkService.findAllNotDeleted();
        modelAndView.addObject("drinks", drinks);
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order/list");
        List<Order> orders = orderService.findAll();
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

}
