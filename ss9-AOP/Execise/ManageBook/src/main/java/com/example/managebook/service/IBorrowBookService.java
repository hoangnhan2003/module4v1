package com.example.managebook.service;
import com.example.managebook.model.Book;
import com.example.managebook.model.BorrowBook;
import com.example.managebook.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowBookService {
    Page<BorrowBook> getAll(Pageable pageable);
    Page<BorrowBook> findAllByUser(Pageable pageable, User user);
    Page<BorrowBook> findAllByBook(Pageable pageable, Book book);
    void save(BorrowBook borrowBook);
    void delete(BorrowBook borrowBook);
    void deleteById(Long id);
    Page<BorrowBook> findAllByStartDate(Pageable pageable,String startDate);
    Page<BorrowBook> findAllByReturnDate(Pageable pageable,String returnDate);
    BorrowBook findByBook(Book book);
    BorrowBook findByBorrowCode(Long borrowCode);

}
