package com.example.demo.service;


import com.example.demo.models.Borrowed;
import com.example.demo.repository.BorrowedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedService {

    public final BorrowedRepository borrowedRepository;

    public BorrowedService(BorrowedRepository borrowedRepository) {
        this.borrowedRepository = borrowedRepository;
    }


    protected List<Borrowed> findAllBorroweds(){
        return borrowedRepository.findAll();
    }
}
