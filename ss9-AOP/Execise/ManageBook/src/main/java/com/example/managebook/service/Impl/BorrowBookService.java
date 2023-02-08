package com.example.managebook.service.Impl;

import com.example.managebook.model.Book;
import com.example.managebook.model.BorrowBook;
import com.example.managebook.model.User;
import com.example.managebook.repository.BorrowBookRepository;
import com.example.managebook.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowBookService implements IBorrowBookService {
    @Autowired
    private BorrowBookRepository borrowBookRepository;


    @Override
    public Page<BorrowBook> getAll(Pageable pageable) {
        return borrowBookRepository.findAll(pageable);
    }

    @Override
    public Page<BorrowBook> findAllByUser(Pageable pageable, User user) {
        return borrowBookRepository.findAllByUser(pageable,user);
    }

    @Override
    public Page<BorrowBook> findAllByBook(Pageable pageable, Book book) {
        return borrowBookRepository.findAllByBook(pageable,book);
    }

    @Override
    public void save(BorrowBook borrowBook) {
        borrowBookRepository.save(borrowBook);
    }

    @Override
    public void delete(BorrowBook borrowBook) {
        borrowBookRepository.delete(borrowBook);
    }

    @Override
    public void deleteById(Long id) {
        borrowBookRepository.deleteById(id);
    }

    @Override
    public Page<BorrowBook> findAllByStartDate(Pageable pageable, String startDate) {
        return borrowBookRepository.findAllByDate(pageable,startDate);
    }

    @Override
    public Page<BorrowBook> findAllByReturnDate(Pageable pageable, String returnDate) {
        return borrowBookRepository.findAllByReturnDate(pageable,returnDate);
    }

    @Override
    public BorrowBook findByBook(Book book) {
        return borrowBookRepository.findByBook(book);
    }

    @Override
    public BorrowBook findByBorrowCode(Long borrowCode) {
        return borrowBookRepository.findByBorrowCode(borrowCode);
    }
}
