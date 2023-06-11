package com.API_REST.controller.api;


import com.API_REST.dto.FournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Api("fournisseur")
public interface FournisseurApi {

  @PostMapping("fournisseur/create")
  FournisseurDto save(@RequestBody FournisseurDto dto);

  @GetMapping("/{idFournisseur}")
  FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

  @GetMapping("fournisseur/all")
  List<FournisseurDto> findAll();

  @DeleteMapping("/delete/{idFournisseur}")
  void delete(@PathVariable("idFournisseur") Integer id);

}
