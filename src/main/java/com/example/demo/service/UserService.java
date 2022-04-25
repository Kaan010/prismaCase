package com.example.demo.service;


import com.example.demo.models.Borrowed;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BorrowedService borrowedService;

    public UserService(UserRepository userRepository, BorrowedService borrowedService) {
        this.userRepository = userRepository;
        this.borrowedService = borrowedService;
    }
    
    public Set<String> findAllUsersWhoBorrowedAtLeastOneBook(){
        List<Borrowed> allBorroweds = borrowedService.findAllBorroweds();
        return allBorroweds.stream().map(Borrowed::getBorrower_Name).collect(Collectors.toSet());
    } 



}
