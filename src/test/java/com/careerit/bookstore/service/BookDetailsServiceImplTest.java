package com.careerit.bookstore.service;

import com.careerit.bookstore.domain.BookDetails;
import com.careerit.bookstore.repository.BookDetailsRepository;
import com.careerit.bookstore.service.BookDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class BookDetailsServiceImplTest {

    @Mock
    private BookDetailsRepository bookDetailsRepository;

    @InjectMocks
    private BookDetailsServiceImpl bookDetailsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBook() {
        BookDetails book = new BookDetails();
        book.setId(UUID.randomUUID());
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setPrice(19.99);
        book.setCategory("Test Category");
        book.setDescription("Test Description");

        bookDetailsService.createBook(book);

        verify(bookDetailsRepository, times(1)).save(book);
    }
}