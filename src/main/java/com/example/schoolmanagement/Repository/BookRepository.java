package com.example.schoolmanagement.Repository;

import com.example.schoolmanagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

