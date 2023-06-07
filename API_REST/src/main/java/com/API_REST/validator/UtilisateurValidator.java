package com.API_REST.validator;

import com.API_REST.dto.CategoryDto;
import com.API_REST.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("Veuillez renseigner tout les champs obligatoire");
            return errors;
        }

        if (!StringUtils.hasLength(utilisateurDto.getNom())) {
            errors.add("Veuillez renseigner votre nom");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
            errors.add("Veuillez renseigner votre prénom");
        }
        if (!StringUtils.hasLength(utilisateurDto.getEmail())) {
            errors.add("Veuillez renseigner votre adresse mail");
        }
        if (!StringUtils.hasLength(utilisateurDto.getMoteDePasse())) {
            errors.add("Veuillez renseigner un mot de passe");
        }
        if(utilisateurDto.getDateDeNaissance() == null){
            errors.add("Veuillez renseigner votre date de naissance");
        }

        if (utilisateurDto.getAdresse() == null) {
            errors.add("Veuillez renseigner une adresse");
        } else {
        }
        if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
            errors.add("Le champ adresse1 est obligatoire");
        }
        if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
            errors.add("Veuillez renseigner votre ville");
        }
        if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
            errors.add("Veuillez renseigner votre code postale");
        }
        if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
            errors.add("Veuillez renseigner le code catégorie");
        }

        return errors;
    }


}
