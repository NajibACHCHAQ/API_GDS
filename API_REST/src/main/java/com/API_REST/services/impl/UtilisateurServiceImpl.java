package com.API_REST.services.impl;

import com.API_REST.dto.ChangerMotDePasseUtilisateurDto;
import com.API_REST.dto.UtilisateurDto;
import com.API_REST.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    @Override
    public UtilisateurDto save(UtilisateurDto utlisateurDto) {
        return null;
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return null;
    }

    @Override
    public UtilisateurDto findByName(String nom) {
        return null;
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return null;
    }

    @Override
    public UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto utilisateurDto) {
        return null;
    }
}
