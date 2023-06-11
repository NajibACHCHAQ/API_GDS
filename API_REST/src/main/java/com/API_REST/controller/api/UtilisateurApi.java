package com.API_REST.controller.api;


import com.API_REST.dto.ChangerMotDePasseUtilisateurDto;
import com.API_REST.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Api("utilisateurs")
public interface UtilisateurApi {

  @PostMapping("utilisateur/create")
  UtilisateurDto save(@RequestBody UtilisateurDto dto);

  @PostMapping("/update/password")
  UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

  @GetMapping("/{idUtilisateur}")
  UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

  @GetMapping("/find/{email}")
  UtilisateurDto findByEmail(@PathVariable("email") String email);

  @GetMapping("utilisateur/all")
  List<UtilisateurDto> findAll();

  @DeleteMapping("/delete/{idUtilisateur}")
  void delete(@PathVariable("idUtilisateur") Integer id);

}
