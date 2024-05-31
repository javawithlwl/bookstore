package com.careerit.bookstore.service;

import com.careerit.bookstore.domain.BookDetails;

import java.util.List;
import java.util.UUID;

public interface BookDetailsService {
    BookDetails createBook(BookDetails bookDetails);
    BookDetails updateBook(BookDetails bookDetails);
    void deleteBook(UUID id);
    BookDetails readBook(UUID id);
    List<BookDetails> readAllBooks();
    List<BookDetails> searchBooks(String str);
}