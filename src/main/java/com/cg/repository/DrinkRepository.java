package com.cg.repository;

import com.cg.model.Drink;
import com.cg.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

    @Modifying
    @Query("UPDATE Drink d SET d.deleted = true WHERE d.id= :id")
    void deleteDrinkById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Drink d SET d.deleted = false WHERE d.id= :id")
    void restoreDrink(@Param("id") Long id);


    @Query("SELECT d FROM Drink d WHERE d.deleted = false ORDER BY d.id DESC")
    List<Drink> findAllNotDeleted();

    @Query("SELECT d FROM Drink d WHERE d.deleted = true ORDER BY d.id DESC")
    List<Drink> findAllDeleted();

    @Query("SELECT COUNT(d.id) from Drink d WHERE d.deleted = false")
    Integer countDrink();
}
