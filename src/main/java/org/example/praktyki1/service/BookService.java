package org.example.praktyki1.service;

import org.example.praktyki1.dto.BookDTO;
import org.example.praktyki1.entity.Book;
import org.example.praktyki1.mapper.BookMapper;
import org.example.praktyki1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }

    public Optional<BookDTO> getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(bookMapper::toDTO);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book bookRequest = bookMapper.toEntity(bookDTO);
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setName(bookRequest.getName());
        existingBook.setAutor(bookRequest.getAutor());
        existingBook.setRokWydania(bookRequest.getRokWydania());
        existingBook.setCena(bookRequest.getCena());
        Book updatedBook = bookRepository.save(existingBook);
        return bookMapper.toDTO(updatedBook);
    }
}
