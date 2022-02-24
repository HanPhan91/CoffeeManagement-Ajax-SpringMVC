package com.cg.service;

import com.cg.model.Drink;
import com.cg.model.Staff;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrinkService extends IGeneralService<Drink> {

    void deleteDrinkById(@Param("id") Long id);

    void restoreDrink(@Param("id") Long id);

    List<Drink> findAllNotDeleted();

    List<Drink> findAllDeleted();

    Integer countDrink();

}
