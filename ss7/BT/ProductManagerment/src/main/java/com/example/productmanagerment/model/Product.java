package com.example.productmanagerment.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long productCode;
    @NotBlank(message = "Product name is not null!!!")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$",message = "Product name isn't contain special character!!")
    private String productName;
    @Column(columnDefinition = "text")
    @NotBlank(message = "Product detail is not blank!!!")
    private String productDT;
    @Min(value = 1,message = "Price must be higher than 0!!")
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
