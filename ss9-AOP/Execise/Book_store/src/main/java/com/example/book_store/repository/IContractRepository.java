package com.example.book_store.repository;

import com.example.book_store.model.Book;
import com.example.book_store.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface IContractRepository extends JpaRepository<Contract,Long> {
    Page<Contract> findAllByStartTimeIsLessThan(String startTime, Pageable pageable);
    Contract findByContractCode(Long contractCode);
    Page<Contract> findAllByBook(Book book,Pageable pageable);
    void deleteByContractCode(Long contractCode);
}
