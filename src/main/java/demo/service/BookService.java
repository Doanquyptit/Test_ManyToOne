package demo.service;

import demo.model.Book;
import demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(int id) {
        return bookRepository.findById(id);
    }

    public Book add(Book st) {
        return bookRepository.save(st);
    }

    public Book update(int id, Book st) {
        st.id = id;
        return bookRepository.save(st);
    }

    public void delete(int id) {
        bookRepository.deleteById(id);
    }



}