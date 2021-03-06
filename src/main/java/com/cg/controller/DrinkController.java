package com.cg.controller;

import com.cg.model.CatalogDrink;
import com.cg.model.Drink;
import com.cg.service.CatalogDrinkService;
import com.cg.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/drinks")
public class DrinkController {
    @Autowired
    private DrinkService drinkService;
    @Autowired
    private CatalogDrinkService catalogDrinkService;


    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("drink/list");
        List<Drink> drinks = drinkService.findAllNotDeleted();
        List<CatalogDrink> catalogDrinks = catalogDrinkService.findAllNotDeleted();
        modelAndView.addObject("catalogs", catalogDrinks);
        modelAndView.addObject("drinks", drinks);
        return modelAndView;
    }

    @GetMapping("/deleted")
    public ModelAndView showListDeleted() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("drink/listDeleted");
        List<Drink> drinks = drinkService.findAllDeleted();
        modelAndView.addObject("drinks", drinks);
        return modelAndView;
    }
}
