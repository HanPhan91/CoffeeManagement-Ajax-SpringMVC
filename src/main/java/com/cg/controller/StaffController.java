package com.cg.controller;

import com.cg.model.Staff;
import com.cg.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private StaffService staffService;


    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staff/list");
        List<Staff> staffs = staffService.findAllNotDeleted();
        modelAndView.addObject("staffs", staffs);
        return modelAndView;
    }
}
