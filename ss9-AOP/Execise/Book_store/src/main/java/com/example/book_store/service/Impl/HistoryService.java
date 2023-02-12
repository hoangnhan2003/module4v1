package com.example.book_store.service.Impl;

import com.example.book_store.model.History;
import com.example.book_store.repository.IHistoryRepository;
import com.example.book_store.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;


@Service
public class HistoryService implements IHistoryService {
    @Autowired
    private IHistoryRepository historyRepository;

    @Override
    public void save(History history) {
        historyRepository.save(history);
    }

    @Override
    public Page<History> getAll(Pageable pageable) {
        return historyRepository.findAll(pageable);
    }


}
