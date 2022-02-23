package com.cg.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tên thức uống là bắt buộc")
    @Size(min = 5, max = 50, message = "Tên thức uống phải nằm trong khoảng 5-50 ký tự")
    @Column(name = "drink_name")
    private String drinkName;



    @Digits(integer = 12, fraction = 0)
//    @Column(updatable = false)
    @NotNull(message = "Giá thức uống là bắt buộc")
    @DecimalMin(value = "500", message = "Giá thức uống phải từ 500d đến 100.000d")
    @DecimalMax(value = "100000", message = "Giá thức uống phải từ 500d đến 100.000d")
    private BigDecimal price;

    private String description;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Ho_Chi_Minh")
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    public Drink(Long id, String drinkName, BigDecimal price, String description, boolean deleted, Date createdAt) {
        this.id = id;
        this.drinkName = drinkName;
        this.price = price;
        this.description = description;
        this.deleted = deleted;
        this.createdAt = createdAt;
    }

    public Drink() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
