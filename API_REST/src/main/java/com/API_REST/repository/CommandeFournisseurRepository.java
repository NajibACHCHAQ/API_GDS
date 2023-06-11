package com.API_REST.repository;

import com.API_REST.model.CommandeClient;
import com.API_REST.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CommandeFournisseurRepository extends JpaRepository< CommandeFournisseur,Integer> {


    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

    List<CommandeClient> findAllByFournisseurId(Integer id);
}
