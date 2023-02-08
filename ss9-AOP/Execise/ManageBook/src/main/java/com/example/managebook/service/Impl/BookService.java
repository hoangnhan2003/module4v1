package com.example.managebook.service.Impl;

import com.example.managebook.model.Book;
import com.example.managebook.repository.BookRepository;
import com.example.managebook.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public Page<Book> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAllByBookTitle(Pageable pageable, String title) {
        return bookRepository.findAllByNameLike(pageable,title);
    }

    @Override
    public Page<Book> findAllByCategory(Pageable pageable, String category) {
        return bookRepository.findAllByCategoryLike(pageable,category);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findByBookId(id);
    }
}
