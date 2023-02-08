package com.example.book_store.service;

import com.example.book_store.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> getAll(Pageable pageable);
    Page<Book> findAllBookTitleLike(String title,Pageable pageable);
    Page<Book> findAllBookCategoryLike(String categoryLike,Pageable pageable);
    void save(Book book);
    void deleteByBookId(Long bookId);
    void deleteBook(Book book);
    Book findByBookId(Long bookId);
}
