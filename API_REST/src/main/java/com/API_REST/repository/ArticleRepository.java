package com.API_REST.repository;

import com.API_REST.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository< Article, Integer> {


}
