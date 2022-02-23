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
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Modifying
    @Query("UPDATE Staff s SET s.deleted = true WHERE s.id= :id")
    void deleteDrinkById(@Param("id") Long id);

    @Query("SELECT s FROM Staff s WHERE s.deleted = false ORDER BY s.id DESC")
    List<Staff> findAllNotDeleted();

    @Query("SELECT COUNT(s.id) from Staff s WHERE s.deleted = false")
    Integer countStaff();
}
