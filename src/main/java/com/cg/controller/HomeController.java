package com.cg.controller;


import com.cg.service.DrinkService;
import com.cg.service.OrderService;
import com.cg.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    DrinkService drinkService;
    @Autowired
    StaffService staffService;
    @Autowired
    OrderService orderService;

    @GetMapping
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        int countDrink= drinkService.countDrink();
        int countStaff= staffService.countStaff();
        String totalAmount = orderService.incomeToday();
        String totalAmountMonth = orderService.incomeToMonth();
        modelAndView.addObject("countDrink",countDrink);
        modelAndView.addObject("countStaff",countStaff);
        modelAndView.addObject("totalAmount",totalAmount);
        modelAndView.addObject("totalAmountMonth",totalAmountMonth);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
