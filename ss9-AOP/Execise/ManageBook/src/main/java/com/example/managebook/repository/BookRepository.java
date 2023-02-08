package com.example.managebook.repository;

import com.example.managebook.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    Page<Book> findAllByNameLike(Pageable pageable,String name);
    Book findByBookId(Long bookId);
    Page<Book> findAllByCategoryLike(Pageable pageable,String category);
    void deleteByBookId(Long bookId);
}
