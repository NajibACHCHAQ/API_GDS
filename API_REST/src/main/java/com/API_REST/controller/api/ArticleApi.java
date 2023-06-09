package com.API_REST.controller.api;

import com.API_REST.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import static com.API_REST.utils.Constants.APP_ROOT;
public interface ArticleApi {
    @PostMapping(value = APP_ROOT + "/article/crete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    default ArticleDto save( @RequestBody ArticleDto articleDto) {
        return null;
    }

    @GetMapping(value = APP_ROOT + "/article/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT + "/article/{codeArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT + "/article/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/article/delete/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    void delete (@PathVariable("idArticle")Integer id);
}
