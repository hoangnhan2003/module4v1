package com.example.managebook.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "borrowBook")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowCode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @NotBlank(message = "this field is required to enter!")
    private String date;
    private String returnDate;

    public BorrowBook(Long borrowCode, User user, Book book, String date, String returnDate) {
        this.borrowCode = borrowCode;
        this.user = user;
        this.book = book;
        this.date = date;
        this.returnDate = returnDate;
    }

    public BorrowBook(User user, Book book, String date) {
        this.user = user;
        this.book = book;
        this.date = date;
    }

    public BorrowBook() {
    }

    public BorrowBook(Long borrowCode, User user, Book book, String date) {
        this.borrowCode = borrowCode;
        this.user = user;
        this.book = book;
        this.date = date;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Long getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(Long borrowCode) {
        this.borrowCode = borrowCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
