package com.example.borrowerapi.controller;


import com.example.bookapi.entity.Book;
import com.example.bookapi.exception.ResourceNotFoundException;
import com.example.borrowerapi.entity.Borrower;
import com.example.borrowerapi.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/borrowers")
public class BorrowerController {
    private final BorrowerRepository borrowerRepository;

    @Autowired
    public BorrowerController(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @GetMapping
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    @PostMapping
    public Borrower createBorrower(@RequestBody Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    @GetMapping("/{id}/books")
    public List<Book> getBooksBorrowedByBorrower(@PathVariable Long id) {
        Borrower borrower = borrowerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + id));

        return borrower.getBooks();
    }

    // Other CRUD APIs for Borrower can be added here
}
