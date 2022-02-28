package com.cg.controller;

import com.cg.model.CatalogDrink;
import com.cg.service.CatalogDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/catalogs")
public class CatalogDrinkController {

    @Autowired
    CatalogDrinkService catalogDrinkService;

    @GetMapping
    public ModelAndView listCatalog(){
        ModelAndView modelAndView = new ModelAndView();
        List<CatalogDrink> catalogs = catalogDrinkService.findAllNotDeleted();
        modelAndView.setViewName("catalogDrink/list");
        modelAndView.addObject("catalogs",catalogs);
        return modelAndView;
    }

    @GetMapping("/deleted")
    public ModelAndView listCatalogDeleted(){
        ModelAndView modelAndView = new ModelAndView();
        List<CatalogDrink> catalogs = catalogDrinkService.findAllDeleted();
        modelAndView.setViewName("catalogDrink/listDeleted");
        modelAndView.addObject("catalogs",catalogs);
        return modelAndView;
    }
}
