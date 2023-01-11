package com.example.quanlitinh.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeCustomer")
    private Long codeCustomer;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "id_province")
    private Province province;

    public Customer() {
    }

    public Customer(Long codeCustomer, String firstName, String lastName) {
        this.codeCustomer = codeCustomer;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(Long codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
