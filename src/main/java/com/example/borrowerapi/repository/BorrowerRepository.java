package com.example.borrowerapi.repository;

import com.example.borrowerapi.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}

