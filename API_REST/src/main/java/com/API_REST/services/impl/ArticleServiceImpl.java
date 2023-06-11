package com.API_REST.services.impl;

import com.API_REST.dto.ArticleDto;
import com.API_REST.exception.EntityNotFoundException;
import com.API_REST.exception.ErrorCodes;
import com.API_REST.exception.InvalidEntityException;
import com.API_REST.model.Article;
import com.API_REST.repository.ArticleRepository;
import com.API_REST.services.ArticleService;
import com.API_REST.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {


    private ArticleRepository articleRepository;  // Création d'une instance de ArticleRepository

    @Autowired // Injection par constructeur de Article Repository
    public ArticleServiceImpl(
            ArticleRepository articleRepository
    ) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto); // Création d'une list d'erreur
        if (!errors.isEmpty()) {  // Si l'article que l'on save n'est pas valide on leve une exception defini dans la class ERrrorcode
            log.error("Article is not valid {}", articleDto); // Affichage console de l'erreur
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors); // On leve une exception et on affiche le code error defini
        }
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
        // sinon on Appel la fonction save si l'article est valide
    }

    @Override
    public ArticleDto findById(Integer id) {

        if (id == null) { // Si l'Id est = null on renvoi l'erreur
            log.error("Article Id est null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);

        ArticleDto articleDto = ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto).orElseThrow(() ->
                new EntityNotFoundException("Aucun article trouvé avec l'id " + id, ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (StringUtils.hasLength(codeArticle)) {
            log.error("Article code is null");
        }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);

        ArticleDto articleDto = ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto)
                .orElseThrow(() ->
                new EntityNotFoundException("Aucun article trouvé avec le code " + id, ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return ;
        }
        articleRepository.deleteById(id);
    }
}
