package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Entity.Library;
import com.example.schoolmanagement.Repository.BookRepository;
import com.example.schoolmanagement.Repository.LibraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {
	@Autowired
	LibraryRepository libraryRepository;
   

    public LibraryController(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Long id) {
        return libraryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryRepository.save(library);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLibrary(@PathVariable Long id, @RequestBody Library libraryDetails) {
        if (!libraryRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Library with the provided ID does not exist."); 
            }
        Library library = libraryRepository.findById(id).orElseThrow();
        library.setName(libraryDetails.getName());
        library.setBooks(libraryDetails.getBooks());
        libraryRepository.save(library);
        return ResponseEntity.ok("Library updated successfully."); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLibrary(@PathVariable Long id) {
        if (!libraryRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Library with the provided ID does not exist."); 
        }
        libraryRepository.deleteById(id); 
        return ResponseEntity.ok("Library deleted successfully."); 
    }
}