package com.app.springmvc.domain;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: in708bhugad
 * Date: 05-01-2020
 * Time: 13:53
 * inside the package - com.app.springmvc.domain
 * To change this template use File | Settings | File and Code Templates.
 */

public class Product {

    private Integer id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
