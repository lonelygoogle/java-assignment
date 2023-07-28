package com.example.borrowerapi.entity;

import com.example.bookapi.entity.Book;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table
public class Borrower implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="given_name")
    private String givenName;

    @Column(name="family_name")
    private String familyName;

    @OneToMany(mappedBy = "borrower")
    private Set<Book> books;

}

