package com.cg.controller.api;

import com.cg.exception.DataInputException;
import com.cg.model.CatalogDrink;
import com.cg.model.Drink;
import com.cg.service.CatalogDrinkService;
import com.cg.service.DrinkService;
import com.cg.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogDrinkRestController {
    @Autowired
    private CatalogDrinkService catalogDrinkService;

    @Autowired
    private AppUtil appUtil;

    @GetMapping("/{id}")
    public ResponseEntity<CatalogDrink> getById(@PathVariable Long id) {
        Optional<CatalogDrink> catalogDrink = catalogDrinkService.findById(id);
        if (catalogDrink.isPresent()) {
            return new ResponseEntity<>(catalogDrink.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@Validated @RequestBody CatalogDrink catalogDrink,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        } else {
            catalogDrink.setId(0L);
            CatalogDrink createDrink = catalogDrinkService.save(catalogDrink);
            return new ResponseEntity<>(createDrink, HttpStatus.CREATED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@Validated @RequestBody CatalogDrink catalogDrink,
                                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }
        Long id = catalogDrink.getId();
        Optional<CatalogDrink> optionalCatalogDrink = catalogDrinkService.findById(id);
        if (optionalCatalogDrink.isPresent()) {
            catalogDrinkService.save(catalogDrink);
            Optional<CatalogDrink> updateCatalog = catalogDrinkService.findById(id);
            return new ResponseEntity<>(updateCatalog.get(), HttpStatus.OK);
        } else {
            throw new DataInputException("Catalog's not valid");
        }
    }

    @PutMapping("/delete")
    public ResponseEntity<?> doDelete(@RequestBody CatalogDrink catalogDrink) {
        Optional opCatalog = catalogDrinkService.findById(catalogDrink.getId());
        if (opCatalog.isPresent()) {
            catalogDrinkService.deleteCatalog(catalogDrink.getId());
            catalogDrinkService.deletedDrinkByCatalog(catalogDrink.getId());
            return new ResponseEntity<>(opCatalog.get(), HttpStatus.OK);
        } else {
            throw new DataInputException("Catalog's not valid");
        }
    }

    @PutMapping("/restore")
    public ResponseEntity<?> doRestore(@RequestBody CatalogDrink catalogDrink) {
        Optional opCatalog = catalogDrinkService.findById(catalogDrink.getId());
        if (opCatalog.isPresent()) {
            catalogDrinkService.restoreCatalog(catalogDrink.getId());
            return new ResponseEntity<>(opCatalog.get(), HttpStatus.OK);
        } else {
            throw new DataInputException("Catalog's not valid");
        }
    }
}
