package com.cg.model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;


    private BigDecimal priceDrink;


    private int quantity;


    private BigDecimal totalPrice;

    public OrderDetail() {
    }

    public OrderDetail(@NotNull Order order, @NotNull Drink drink, @NotNull BigDecimal priceDrink, int quantity, @NotNull BigDecimal totalPrice) {
        this.order = order;
        this.drink = drink;
        this.priceDrink = priceDrink;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @NotNull
    public Order getOrder() {
        return order;
    }

    public void setOrder(@NotNull Order order) {
        this.order = order;
    }

    @NotNull
    public Drink getDrink() {
        return drink;
    }

    public void setDrink(@NotNull Drink drink) {
        this.drink = drink;
    }

    @NotNull
    public BigDecimal getPriceDrink() {
        return priceDrink;
    }

    public void setPriceDrink(@NotNull BigDecimal priceDrink) {
        this.priceDrink = priceDrink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NotNull
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(@NotNull BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
