package com.API_REST.services.impl;

import com.API_REST.dto.ArticleDto;
import com.API_REST.dto.CategoryDto;
import com.API_REST.exception.EntityNotFoundException;
import com.API_REST.exception.ErrorCodes;
import com.API_REST.exception.InvalidEntityException;
import com.API_REST.exception.InvalidOperationException;
import com.API_REST.model.Article;
import com.API_REST.model.Category;
import com.API_REST.repository.ArticleRepository;
import com.API_REST.repository.CategoryRepository;
import com.API_REST.services.CategoryService;
import com.API_REST.validator.ArticleValidator;
import com.API_REST.validator.CategoryValidator;
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
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("La category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(CategoryDto.toEntity(dto))
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return null;
        }
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override //Fixe me
    public CategoryDto findByCode(String code) {
        if (StringUtils.hasLength(code)) {
            log.error("The code is null");
            return null;
        }
        return categoryRepository.findCategoryByCode(code)
                .map((Article category) -> CategoryDto.fromEntity(category.getCategory()))
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec le CODE = " + code + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return;
        }
        List<Article> articles = articleRepository.findAllByCategoryId(id);
        if (!articles.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        categoryRepository.deleteById(id);
    }
}
