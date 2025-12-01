package com.example.library.library_service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private Integer publishedYear;
}
