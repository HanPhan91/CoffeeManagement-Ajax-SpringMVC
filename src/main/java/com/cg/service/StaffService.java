package com.cg.service;

import com.cg.model.Drink;
import com.cg.model.Staff;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffService extends IGeneralService<Staff>{

    void deleteDrinkById(@Param("id") Long id);

    List<Staff> findAllNotDeleted();

    Integer countStaff();
}
