package com.API_REST.controller.api;

import com.API_REST.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.API_REST.utils.Constants.APP_ROOT;

public interface ClientApi {


        @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        ClientDto save(@RequestBody ClientDto dto);

        @GetMapping(value = APP_ROOT + "/clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
        ClientDto findById(@PathVariable("idClient") Integer id);

        @GetMapping(value = APP_ROOT + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
        List<ClientDto> findAll();

        @DeleteMapping(value = APP_ROOT + "/clients/delete/{idClient}")
        void delete(@PathVariable("idClient") Integer id);

    }

