package com.API_REST.controller.api;

import com.API_REST.dto.VentesDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Api("ventes")
public interface VentesApi {

  @PostMapping("ventes/create")
  VentesDto save(@RequestBody VentesDto dto);

  @GetMapping("/{idVente}")
  VentesDto findById(@PathVariable("idVente") Integer id);

  @GetMapping("/{codeVente}")
  VentesDto findByCode(@PathVariable("codeVente") String code);

  @GetMapping("ventes/all")
  List<VentesDto> findAll();

  @DeleteMapping("/delete/{idVente}")
  void delete(@PathVariable("idVente") Integer id);

}
