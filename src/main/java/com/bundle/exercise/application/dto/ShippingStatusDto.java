package com.bundle.exercise.application.dto;

public class ShippingStatusDto {
    private String status;
    private SaleDto sale;
    private ProductDto product;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SaleDto getSale() {
        return sale;
    }

    public void setSale(SaleDto sale) {
        this.sale = sale;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
