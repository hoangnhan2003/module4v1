package com.example.book_store.service;

import com.example.book_store.model.History;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;


public interface IHistoryService {
    void save(History history);
    Page<History> getAll(Pageable pageable);
}
