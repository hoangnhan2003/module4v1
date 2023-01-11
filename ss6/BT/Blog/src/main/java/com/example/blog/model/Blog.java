package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    private String codeBlog;
    private String author;
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    private String subject;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(String codeBlog, String author, String title, String content, String subject, Category category) {
        this.codeBlog = codeBlog;
        this.author = author;
        this.title = title;
        this.content = content;
        this.subject = subject;
        this.category = category;
    }

    public Blog(String codeBlog, String author, String title, String content, String subject) {
        this.codeBlog = codeBlog;
        this.author = author;
        this.title = title;
        this.content = content;
        this.subject = subject;
    }

    public Blog() {
    }

    public Blog(String codeBlog, String author, String title, String content) {
        this.codeBlog = codeBlog;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCodeBlog() {
        return codeBlog;
    }

    public void setCodeBlog(String codeBlog) {
        this.codeBlog = codeBlog;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
