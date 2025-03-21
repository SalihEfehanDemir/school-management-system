
package com.example.schoolmanagement.dto;

public class BookDTO {
    private Long id;
    private String name;
    private String author;
    private boolean available;

    public BookDTO(Long id, String name, String author, boolean available) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }
}
