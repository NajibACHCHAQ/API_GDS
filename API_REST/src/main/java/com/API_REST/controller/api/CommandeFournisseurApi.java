package com.API_REST.controller.api;

import com.API_REST.dto.CommandeFournisseurDto;
import com.API_REST.dto.LigneCommandeFournisseurDto;
import com.API_REST.model.EtatCommande;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.API_REST.utils.Constants.*;

@Api("commandefournisseur")
public interface CommandeFournisseurApi {

  @PostMapping()
  CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

  @PatchMapping("/update/etat/{idCommande}/{etatCommande}")
  CommandeFournisseurDto updateEtatCommande(@PathVariable("idCommande") Integer idCommande, @PathVariable("etatCommande") EtatCommande etatCommande);

  @PatchMapping("/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
  CommandeFournisseurDto updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande,
      @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("quantite") BigDecimal quantite);

  @PatchMapping("/update/fournisseur/{idCommande}/{idFournisseur}")
  CommandeFournisseurDto updateFournisseur(@PathVariable("idCommande") Integer idCommande, @PathVariable("idFournisseur") Integer idFournisseur);

  @PatchMapping("/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
  CommandeFournisseurDto updateArticle(@PathVariable("idCommande") Integer idCommande,
      @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("idArticle") Integer idArticle);

  @DeleteMapping("/delete/article/{idCommande}/{idLigneCommande}")
  CommandeFournisseurDto deleteArticle(@PathVariable("idCommande") Integer idCommande, @PathVariable("idLigneCommande") Integer idLigneCommande);

  @GetMapping("/id")
  CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

  @GetMapping("commandeFournisseur/code")
  CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

  @GetMapping("commandeFournisseur/all")
  List<CommandeFournisseurDto> findAll();

  @GetMapping("/lignesCommande/{idCommande}")
  List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(@PathVariable("idCommande") Integer idCommande);

  @DeleteMapping
  void delete(@PathVariable("idCommandeFournisseur") Integer id);

}
