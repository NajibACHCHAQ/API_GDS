package com.API_REST.validator;

import com.API_REST.dto.ArticleDto;
import com.API_REST.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        if (articleDto == null) {
            errors.add("Veuillez renseigner tous les champs obligatoires");
            return errors;
        }

        if (!StringUtils.hasLength(articleDto.getCodeArticle())) {
            errors.add("Veuillez renseigner un code Article");
        }
        if (!StringUtils.hasLength(articleDto.getDesignation())) {
            errors.add("Veuillez renseigner une désignation pour l'article");
        }
        if (!StringUtils.hasLength(articleDto.getCodeArticle())) {
            errors.add("Veuillez renseigner le code Article");
        }
        if (articleDto.getPrixUnitaireHt() == null) {
            errors.add("Veuillez renseigner le prix de l'article Article");
        }
        if (articleDto.getTauxTva() == null) {
            errors.add("Veuillez renseigner le code Article");
        }
        if (articleDto.getCategory() == null) {
            errors.add("Veuillez selectionner une catégorie");
        }

        return errors;
    }
}
