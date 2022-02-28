package com.cg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "catalogs")
public class CatalogDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tên danh mục thức uống không được để trống")
    @Size(min = 3, max = 50, message = "Tên danh mục thức uống phải nằm trong khoảng 3-50 ký tự")
    @Column(name = "name_catalog")
    private String catalogName;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;


    public CatalogDrink() {
    }

    public CatalogDrink(Long id, String catalogName, Boolean deleted) {
        this.id = id;
        this.catalogName = catalogName;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
