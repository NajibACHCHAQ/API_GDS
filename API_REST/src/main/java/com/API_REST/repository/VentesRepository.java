package com.API_REST.repository;

import com.API_REST.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Ventes,Integer> {
}
