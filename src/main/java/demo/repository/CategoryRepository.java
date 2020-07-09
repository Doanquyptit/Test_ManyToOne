package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}