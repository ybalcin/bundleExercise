package com.bundle.exercise.domain.models;

public class Sale extends Base {
    private String saleCode;
    private int productId;

    public String getSaleCode() {
        return saleCode;
    }

    public int getProductId() {
        return productId;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
