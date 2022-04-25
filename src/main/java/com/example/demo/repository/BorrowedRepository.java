package com.example.demo.repository;

import com.example.demo.models.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedRepository extends JpaRepository<Borrowed, String> {
}
