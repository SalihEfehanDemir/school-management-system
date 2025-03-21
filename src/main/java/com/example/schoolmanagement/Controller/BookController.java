
package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.ApiResponse;
import com.example.schoolmanagement.dto.BookDTO;
import com.example.schoolmanagement.entity.Book;
import com.example.schoolmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<BookDTO>>> getAllBooks(Pageable pageable) {
        Page<BookDTO> books = bookRepository.findAll(pageable)
                .map(b -> new BookDTO(b.getId(), b.getName(), b.getAuthor(), b.isAvailable()));
        return ResponseEntity.ok(new ApiResponse<>("success", books));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BookDTO>> addBook(@RequestBody Book book) {
        book.setAvailable(true); // yeni kitaplar varsayılan olarak müsait
        Book saved = bookRepository.save(book);
        BookDTO dto = new BookDTO(saved.getId(), saved.getName(), saved.getAuthor(), saved.isAvailable());
        return ResponseEntity.ok(new ApiResponse<>("success", dto));
    }

    @PutMapping("/{id}/borrow")
    public ResponseEntity<ApiResponse<String>> borrowBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (!book.isAvailable()) {
            return ResponseEntity.badRequest().body(new ApiResponse<>("error", "Book is already borrowed"));
        }
        book.setAvailable(false);
        bookRepository.save(book);
        return ResponseEntity.ok(new ApiResponse<>("success", "Book borrowed successfully"));
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<ApiResponse<String>> returnBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.isAvailable()) {
            return ResponseEntity.badRequest().body(new ApiResponse<>("error", "Book is not borrowed"));
        }
        book.setAvailable(true);
        bookRepository.save(book);
        return ResponseEntity.ok(new ApiResponse<>("success", "Book returned successfully"));
    }
}
