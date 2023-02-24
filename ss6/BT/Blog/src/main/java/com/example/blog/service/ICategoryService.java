package com.example.blog.service;

import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    List<Category> findAll();
    Category findById(Long id);
}
