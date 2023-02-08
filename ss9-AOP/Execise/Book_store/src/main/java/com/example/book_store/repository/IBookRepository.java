package com.example.book_store.repository;

import com.example.book_store.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
    Page<Book> findAllByNameLike(String title, Pageable pageable);
    Page<Book> findAllByCategoryLike(String category,Pageable pageable);
    Book findByBookId(Long bookId);
    void deleteByBookId(Long bookId);
}
