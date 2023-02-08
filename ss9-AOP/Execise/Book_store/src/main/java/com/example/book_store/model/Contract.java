package com.example.book_store.model;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractCode;
    private String startTime;
    private String returnTime;
    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    public Contract(String startTime, Book book) {
        this.startTime = startTime;
        this.book = book;
    }

    public Contract(Long contractCode, String startTime, String returnTime, Book book) {
        this.contractCode = contractCode;
        this.startTime = startTime;
        this.returnTime = returnTime;
        this.book = book;
    }

    public Contract(Long contractCode, String startTime, String returnTime) {
        this.contractCode = contractCode;
        this.startTime = startTime;
        this.returnTime = returnTime;
    }

    public Contract() {

    }

    public Long getContractCode() {
        return contractCode;
    }

    public void setContractCode(Long contractCode) {
        this.contractCode = contractCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
