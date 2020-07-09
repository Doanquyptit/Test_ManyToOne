package demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id @GeneratedValue
    public int id;

    @Column
    public String code;

    @Column
    public String name;



    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    public Author author;

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    public List<Category> categories;
}