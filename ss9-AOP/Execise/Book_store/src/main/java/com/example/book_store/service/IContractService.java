package com.example.book_store.service;

import com.example.book_store.model.Book;
import com.example.book_store.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> getAll(Pageable pageable);
    Page<Contract> findAllContractLessThanStartTime(String startTime,Pageable pageable);
    Page<Contract> findAllByBook(Book book, Pageable pageable);
    Contract findByContractCode(Long contractCode);
    void save(Contract contract);
    void deleteByContractCode(Long contractCode);
    void delete(Contract contract);
}
