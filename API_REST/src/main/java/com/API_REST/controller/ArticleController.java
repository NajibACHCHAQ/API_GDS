package com.API_REST.controller;

import com.API_REST.controller.api.ArticleApi;
import com.API_REST.dto.ArticleDto;
import com.API_REST.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;
    @Autowired // Permet d'injecter automatiquement des instances
    public ArticleController(
            ArticleService articleService
    ){
        this.articleService = articleService;
    }
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
