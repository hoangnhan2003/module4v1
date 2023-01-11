package com.example.blog.service;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAll(Pageable pageable);
    Blog findByTitle(String title);
    Blog findByCodeBlog(String codeBlog);
    void save(Blog blog);
    void delete(String codeBlog);
    void update(Blog blog);
    Page<Blog> findAllByTitle(Pageable pageable,String title);
    Page<Blog> findAllByAuthor(Pageable pageable,String author);
}
