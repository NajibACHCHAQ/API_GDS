package com.API_REST.repository;

import com.API_REST.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {
    List<LigneCommandeClient> findAllByCommandeClientId(Integer id);
}
