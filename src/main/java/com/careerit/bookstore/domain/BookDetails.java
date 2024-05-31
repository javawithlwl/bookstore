package com.careerit.bookstore.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "book_details")
@Getter
@Setter
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "author",nullable = false)
    private String author;
    @Column(name = "price",nullable = false)
    private double price;
    @Column(name = "category",nullable = false)
    private String category;
    @Column(name = "description",nullable = false)
    private String description;
}
