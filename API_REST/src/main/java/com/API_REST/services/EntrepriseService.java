package com.API_REST.services;

import com.API_REST.dto.ArticleDto;
import com.API_REST.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {


    EntrepriseDto save(EntrepriseDto entrepriseDto);

    EntrepriseDto findById(Integer id);

    List<EntrepriseDto> findAll();

    void delete (Integer id);
}
