package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrdeItemDTO {

    private Long ProductId;
    private String name;
    private Double price;
    private Integer quantity;

    public OrdeItemDTO() {}

    public OrdeItemDTO(Long productId, String name, Double price, Integer quantity) {
        ProductId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrdeItemDTO(OrderItem entity) {
        ProductId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

}
