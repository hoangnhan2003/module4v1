package com.example.book_store.repository;

import com.example.book_store.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoryRepository extends JpaRepository<History,String> {

}
