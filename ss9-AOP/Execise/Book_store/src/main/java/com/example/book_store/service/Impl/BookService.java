package com.example.book_store.service.Impl;

import com.example.book_store.model.Book;
import com.example.book_store.repository.IBookRepository;
import com.example.book_store.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;


    @Override
    public Page<Book> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> findAllBookTitleLike(String title, Pageable pageable) {
        return bookRepository.findAllByNameLike(title,pageable);
    }

    @Override
    public Page<Book> findAllBookCategoryLike(String categoryLike, Pageable pageable) {
        return bookRepository.findAllByCategoryLike(categoryLike,pageable);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteByBookId(Long bookId) {
        bookRepository.deleteByBookId(bookId);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book findByBookId(Long bookId) {
        return bookRepository.findByBookId(bookId);
    }
}
