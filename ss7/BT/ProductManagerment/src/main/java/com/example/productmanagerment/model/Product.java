package com.example.productmanagerment.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCode;
    private String productName;
    @Column(columnDefinition = "text")
    private String productDT;
    private Float price;

    public Product() {
    }

    public Product(Long productCode, String productName, String productDT, Float price) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDT = productDT;
        this.price = price;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDT() {
        return productDT;
    }

    public void setProductDT(String productDT) {
        this.productDT = productDT;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
