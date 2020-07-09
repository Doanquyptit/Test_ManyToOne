package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id @GeneratedValue
    public int id;

    @Column
    public String code;

    @Column
    public String name;



    @JsonIgnore
    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "categories")
    public List<Book> books;

    @JsonIgnore
    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "categories")
    public List<Author>  authors;

}