package com.API_REST.services;


import com.API_REST.dto.ChangerMotDePasseUtilisateurDto;
import com.API_REST.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto utlisateurDto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto findByName(String nom);

    List<UtilisateurDto> findAll();

    void delete (Integer id);

    UtilisateurDto findByEmail(String email);

    UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto utilisateurDto);
}
