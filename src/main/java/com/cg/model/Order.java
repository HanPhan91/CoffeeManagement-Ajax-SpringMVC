package com.cg.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long id = System.currentTimeMillis() / 1000;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Ho_Chi_Minh")
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    public Order() {
    }

    public Order(Long id, Date createdAt, BigDecimal totalAmount) {
        this.id = id;
        this.createdAt = createdAt;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
