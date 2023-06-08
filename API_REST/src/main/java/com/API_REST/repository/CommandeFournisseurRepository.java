package com.API_REST.repository;

import com.API_REST.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CommandeFournisseurRepository extends JpaRepository< CommandeFournisseur,Integer> {
}
