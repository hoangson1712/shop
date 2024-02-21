package com.shop.nghoso.entity;

import jakarta.persistence.*;
@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "category")
    private String category;
    @Column(name = "new_price")
    private double new_price;
    @Column(name = "old_price")
    private double old_price;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getNew_price() {
        return new_price;
    }
    public void setNew_price(double new_price) {
        this.new_price = new_price;
    }
    public double getOld_price() {
        return old_price;
    }
    public void setOld_price(double old_price) {
        this.old_price = old_price;
    }
}
