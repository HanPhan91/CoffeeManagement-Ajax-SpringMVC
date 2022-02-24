package com.cg.controller.api;

import com.cg.exception.DataInputException;
import com.cg.model.*;
import com.cg.service.DrinkService;
import com.cg.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drinks")
public class DrinkRestController {
    @Autowired
    private DrinkService drinkService;

    @Autowired
    private AppUtil appUtil;

    @GetMapping("/{id}")
    public ResponseEntity<Drink> getById(@PathVariable Long id) {
        Optional<Drink> drink = drinkService.findById(id);
        if (drink.isPresent()) {
            return new ResponseEntity<>(drink.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@Validated @RequestBody Drink drink,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        } else {
            drink.setId(0L);
            Drink createDrink = drinkService.save(drink);
            return new ResponseEntity<>(createDrink, HttpStatus.CREATED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@Validated @RequestBody Drink drink, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }
        Long id = drink.getId();
        Optional<Drink> optionalDrink = drinkService.findById(id);
        if (optionalDrink.isPresent()) {
            drinkService.save(drink);
            Optional<Drink> updateDrink = drinkService.findById(id);
            return new ResponseEntity<>(updateDrink.get(), HttpStatus.OK);
        } else {
            throw new DataInputException("Drink's not valid");
        }

    }

    @PutMapping("/delete")
    public ResponseEntity<?> doDelete(@RequestBody Drink drink) {
        Optional opDrink = drinkService.findById(drink.getId());
        if (opDrink.isPresent()) {
            drinkService.deleteDrinkById(drink.getId());
            return new ResponseEntity<>(opDrink.get(), HttpStatus.OK);
        } else {
            throw new DataInputException("Customer's not valid");
        }
    }

    @PutMapping("/restore")
    public ResponseEntity<?> doRestore(@Validated @RequestBody Drink drink, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }
        Long id = drink.getId();
        Optional<Drink> optionalDrink = drinkService.findById(id);
        if (optionalDrink.isPresent()) {
            drinkService.save(drink);
            drinkService.restoreDrink(id);
            Optional<Drink> updateDrink = drinkService.findById(id);
            return new ResponseEntity<>(updateDrink.get(), HttpStatus.OK);
        } else {
            throw new DataInputException("Drink's not valid");
        }

    }
}
