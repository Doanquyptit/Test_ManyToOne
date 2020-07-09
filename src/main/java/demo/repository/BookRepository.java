package demo.repository;


import demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Integer> {

    //Optional<Book> findByCode(String code);

    //List<Book> findByAuthorName(String authorName, Pageable pageable);
}