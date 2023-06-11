package com.API_REST.services.impl;

import com.API_REST.dto.FournisseurDto;
import com.API_REST.services.FournisseurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    @Override
    public FournisseurDto save(FournisseurDto articleDto) {
        return null;
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return null;
    }

    @Override
    public FournisseurDto findByName(String nom) {
        return null;
    }

    @Override
    public List<FournisseurDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
