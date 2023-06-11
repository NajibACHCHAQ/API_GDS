package com.API_REST.repository;

import com.API_REST.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {

    List<LigneVente> findAllByArticleId(Integer idArticle);

    List<LigneVente> findAllByVenteId(Integer id);
}
