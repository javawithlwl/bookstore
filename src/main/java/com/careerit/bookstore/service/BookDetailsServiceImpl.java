package com.careerit.bookstore.service;

import com.careerit.bookstore.domain.BookDetails;
import com.careerit.bookstore.repository.BookDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookDetailsServiceImpl implements BookDetailsService {

    private final BookDetailsRepository bookDetailsRepository;

    @Override
    public BookDetails createBook(BookDetails bookDetails) {
        Assert.notNull(bookDetails, "BookDetails must not be null");
        bookDetailsRepository.save(bookDetails);
        log.info("Book with title : {} is created with id :  {}", bookDetails.getTitle(), bookDetails.getId());
        return bookDetails;
    }

    @Override
    public BookDetails updateBook(BookDetails bookDetails) {
        Assert.notNull(bookDetails, "BookDetails must not be null");
        Assert.notNull(bookDetails.getId(), "Book id must not be null");
        log.info("Book with id : {} is requested for update", bookDetails.getId());
        bookDetailsRepository.save(bookDetails);
        log.info("Book with id : {} is updated", bookDetails.getId());
        return bookDetails;
    }

    @Override
    public void deleteBook(UUID id) {
        Assert.notNull(id, "Book id must not be null");
        bookDetailsRepository.deleteById(id);
    }

    @Override
    public BookDetails readBook(UUID id) {
        Assert.notNull(id, "Book id must not be null");
        return bookDetailsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book with id : " + id + " not found"));
    }

    @Override
    public List<BookDetails> readAllBooks() {
        return bookDetailsRepository.findAll();
    }

    @Override
    public List<BookDetails> searchBooks(String str) {
        Assert.hasText(str, "Keyword must not be empty");
        List<BookDetails> bookDetails = bookDetailsRepository.search(str);
        log.info("Books found for keyword : {} is : {}", str, bookDetails.size());
        return bookDetails;
    }
}