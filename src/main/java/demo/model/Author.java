package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "author")
public class Author {

    @Id @GeneratedValue
    public int id;

    @Column
    public String code;
    @Column
    public String name;


    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "author")
    public List<Book> books;

    @ManyToMany
    @JoinTable(
            name = "author_category",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    public List<Category> categories;
}