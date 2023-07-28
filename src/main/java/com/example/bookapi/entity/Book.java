package com.example.bookapi.entity;

import com.example.borrowerapi.entity.Borrower;
import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table
public class Book  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="givenname_name")
    private String name;

    @Column(name="isbn")
    private String isbn;

    @Column(name="date_published")
    private Date datePublished;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

}

