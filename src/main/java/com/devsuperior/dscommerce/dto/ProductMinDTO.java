package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductMinDTO {

    private Long id;
    private String name;
    private Double price;
    private String imgURL;

    public ProductMinDTO() {}

    public ProductMinDTO(Long id, String name, Double price, String imgURL) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgURL = imgURL;
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imgURL = entity.getImgURL();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgURL() {
        return imgURL;
    }
}
