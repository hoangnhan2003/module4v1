package com.example.book_store.service.Impl;

import com.example.book_store.model.Book;
import com.example.book_store.model.Contract;
import com.example.book_store.repository.IContractRepository;
import com.example.book_store.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> getAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllContractLessThanStartTime(String startTime, Pageable pageable) {
        return contractRepository.findAllByStartTimeIsLessThan(startTime,pageable);
    }

    @Override
    public Page<Contract> findAllByBook(Book book, Pageable pageable) {
        return contractRepository.findAllByBook(book,pageable);
    }

    @Override
    public Contract findByContractCode(Long contractCode) {
        return contractRepository.findByContractCode(contractCode);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void deleteByContractCode(Long contractCode) {
        contractRepository.deleteByContractCode(contractCode);
    }

    @Override
    public void delete(Contract contract) {
        contractRepository.delete(contract);
    }
}

