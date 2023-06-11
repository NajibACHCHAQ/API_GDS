package com.API_REST.services;

import com.API_REST.dto.EntrepriseDto;
import com.API_REST.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto articleDto);

    FournisseurDto findById(Integer id);

    FournisseurDto findByName(String nom);

    List<FournisseurDto> findAll();

    void delete (Integer id);
}
