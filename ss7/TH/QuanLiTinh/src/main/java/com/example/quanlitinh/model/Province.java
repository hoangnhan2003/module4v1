package com.example.quanlitinh.model;


import javax.persistence.*;




@Entity
@Table(name = "procinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_province")
    private Long codeProvince;
    private String name;

    public Province() {

    }

    public Province(String name) {
        this.name = name;
    }

    public Long getCodeProvince() {
        return codeProvince;
    }

    public void setCodeProvince(Long codeProvince) {
        this.codeProvince = codeProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
