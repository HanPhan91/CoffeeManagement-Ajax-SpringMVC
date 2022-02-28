package com.cg.repository;

import com.cg.model.Order;
import com.cg.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query("SELECT d FROM OrderDetail d WHERE d.order = :order")
    List<OrderDetail> findByOrder(@Param("order") Order order);

}
