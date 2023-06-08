package com.API_REST.repository;

import com.API_REST.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ExceptionHandler;


public interface EntrepriseRepository extends JpaRepository< Entreprise,Integer> {
}
