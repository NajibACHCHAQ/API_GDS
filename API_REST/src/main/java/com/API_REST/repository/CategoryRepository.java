package com.API_REST.repository;

import com.API_REST.model.Article;
import com.API_REST.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Optional<Article> findCategoryByCode(String codeArticle);
}
