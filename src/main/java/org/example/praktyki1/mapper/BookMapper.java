package org.example.praktyki1.mapper;

import org.example.praktyki1.dto.BookDTO;
import org.example.praktyki1.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookDTO bookDTO) {
        return new Book(
                bookDTO.getId(),
                bookDTO.getName(),
                bookDTO.getAutor(),
                bookDTO.getRokWydania(),
                bookDTO.getCena()
        );
    }

    public BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getName(),
                book.getAutor(),
                book.getRokWydania(),
                book.getCena()
        );
    }
}
