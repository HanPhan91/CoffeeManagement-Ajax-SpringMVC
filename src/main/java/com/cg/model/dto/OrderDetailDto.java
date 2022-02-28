package com.cg.model.dto;

import java.math.BigDecimal;

public class OrderDetailDto {
    private Long drinkId;
    private String drinkName;
    private int drinkQuantity;
    private BigDecimal price;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long drinkId, String drinkName, int drinkQuantity, BigDecimal price) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkQuantity = drinkQuantity;
        this.price = price;
    }

    public Long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Long drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getDrinkQuantity() {
        return drinkQuantity;
    }

    public void setDrinkQuantity(int drinkQuantity) {
        this.drinkQuantity = drinkQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
