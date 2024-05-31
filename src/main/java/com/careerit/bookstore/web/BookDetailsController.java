package com.careerit.bookstore.web;

import com.careerit.bookstore.domain.BookDetails;
import com.careerit.bookstore.service.BookDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookDetailsController {

    private final BookDetailsService bookDetailsService;

    @PostMapping
    public ResponseEntity<BookDetails> createBook(@RequestBody BookDetails bookDetails){
        return ResponseEntity.ok(bookDetailsService.createBook(bookDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetails> readBook(@PathVariable UUID id){
        return ResponseEntity.ok(bookDetailsService.readBook(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id){
        bookDetailsService.deleteBook(id);
        return ResponseEntity.ok("Book with id : "+id+" is deleted");
    }

    @PutMapping
    public ResponseEntity<BookDetails> updateBook(@RequestBody BookDetails bookDetails){
        return ResponseEntity.ok(bookDetailsService.updateBook(bookDetails));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDetails>> readAllBooks(){
        return ResponseEntity.ok(bookDetailsService.readAllBooks());
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDetails>> searchBooks(@RequestParam String str){
        return ResponseEntity.ok(bookDetailsService.searchBooks(str));
    }
}
