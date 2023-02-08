package com.example.managebook.service;

import com.example.managebook.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> getAll(Pageable pageable);
    void save(Book book);
    void delete(Book book);
    void deleteById(Long id);
    Page<Book> findAllByBookTitle(Pageable pageable,String title);
    Page<Book> findAllByCategory(Pageable pageable,String category);
    Book findById(Long id);
}
