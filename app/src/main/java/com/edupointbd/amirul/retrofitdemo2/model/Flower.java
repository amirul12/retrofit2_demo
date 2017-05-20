/*
 * Copyright (c) 2017. I am Amirul Islam. All @copyRight Reserved
 */

package com.edupointbd.amirul.retrofitdemo2.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by amirul on 20-May-17.
 * www.edupointbd.com
 */

public class Flower implements Serializable{

    @Expose
    private String category;
    @Expose
    private Double price;
    private String instructions;
    @Expose
    private String photo;
    @Expose
    private String name;
    @Expose
    private int productId;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
