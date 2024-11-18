package org.example.praktyki1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String autor;
    private int rokWydania;
    private int cena;

    public Book(Long id, String name, String autor, int rokWydania, int cena) {
        this.id = id;
        this.name = name;
        this.autor = autor;
        this.rokWydania = rokWydania;
        this.cena = cena;
    }

}
