package demo.controller;

import demo.model.Book;
import demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RestController
public class BookController {
        @Autowired private BookService bookService;
        @PersistenceContext private EntityManager em;
        @GetMapping("/get_all_Book")
        public List<Book> getAllBooks() {
            return bookService.getAll();
        }

        @GetMapping("/get_Book/{id}")
        public Book getBook(@PathVariable("id") int id) {
            return bookService.getById(id).get();
        }

        @GetMapping("/get_Book_Category")
        public List<Book> getBook_by_Category(String keyword){
            String querySrt ="select book.*, group_concat(category.name,'@') as categories from book join book_category on book.id=book_category.book_id\r\n"+
                    "join category on category.id=book_category.category_id \r\n"+
                    "group by book.id\r\n" +
                    "having categories LIKE ?1";
            Query query = (Query) em.createNativeQuery(querySrt, Book.class);
            query.setParameter(1,"%" + keyword + "%");
            return query.getResultList();
        }
        @PostMapping("/add_book")
        public Book addBook(@RequestBody Book book) {
            return bookService.add(book);
        }
        @PutMapping("/update_book/{id}")
        public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
            return bookService.update(id, book);
        }
        @DeleteMapping("/delete_book/{id}")
        public void deleteBook(@PathVariable("id") int id) {
            bookService.delete(id);
        }
}