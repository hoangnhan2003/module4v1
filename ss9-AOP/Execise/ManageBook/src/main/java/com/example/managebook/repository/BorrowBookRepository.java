package com.example.managebook.repository;

import com.example.managebook.model.Book;
import com.example.managebook.model.BorrowBook;
import com.example.managebook.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository<BorrowBook,Long> {
    Page<BorrowBook> findAllByUser(User userId, Pageable pageable);
    Page<BorrowBook> findAllByBook(Pageable pageable, Book bookId);
    BorrowBook findByBook(Book book);
    Page<BorrowBook> findAllByDate(Pageable pageable,String startDate);
    Page<BorrowBook> findAllByReturnDate(Pageable pageable,String returnDate);
    BorrowBook findByBorrowCode(Long borrowCode);
}
