package com.example.bookapi.entity;

import com.example.borrowerapi.entity.Borrower;
import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String isbn;
    private Date datePublished;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    // Constructors, getters, and setters
}

