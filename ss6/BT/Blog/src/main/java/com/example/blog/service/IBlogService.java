package com.example.blog.service;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAll(Pageable pageable);
    List<Blog> getAll();
    List<Blog> findAllBlogByTitle(String title);
    Blog saveBlog(Blog blog);
    Blog findByTitle(String title);
    Blog findByCodeBlog(Long codeBlog);
    void save(Blog blog);
    void delete(Long codeBlog);
    void update(Blog blog);
    Page<Blog> findAllByTitle(Pageable pageable,String title);
    Page<Blog> findAllByAuthor(Pageable pageable,String author);
    List<Blog> findAllByTitleLike(String title);

}
