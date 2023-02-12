package com.example.blog.service.impl;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> getAll(Pageable pageable) {
        Page<Blog> blogList = blogRepository.findAll(pageable);
        return blogList;
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllBlogByTitle(String title) {
        List<Blog> blogList =  blogRepository.findBlogsByTitleLike(title);
        return blogList;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog findByTitle(String title) {
        return blogRepository.findBlogByTitle(title);
    }

    @Override
    public Blog findByCodeBlog(String codeBlog) {
        return blogRepository.findBlogByCodeBlog(codeBlog);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(String codeBlog) {
        blogRepository.deleteByCodeBlog(codeBlog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAllByTitle(Pageable pageable, String title) {
        return blogRepository.findAllByTitleLike(pageable,"%"+title+"%");
    }

    @Override
    public Page<Blog> findAllByAuthor(Pageable pageable, String author) {
        return blogRepository.findAllByAuthorLike(pageable,"%"+author+"%");
    }
}
