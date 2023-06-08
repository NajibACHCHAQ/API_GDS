package com.API_REST.repository;

import com.API_REST.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository< CommandeClient,Integer> {
}
