package com.cfs.gerador.contrato.controllers;

import com.cfs.gerador.contrato.dtos.ContratoDTO;
import com.cfs.gerador.contrato.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService service;

    @GetMapping
    public ResponseEntity<Page<ContratoDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerpage", defaultValue = "12") Integer linesPerPae,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "razaoSocialContratada") String orderBy
    ){

        PageRequest pageRequest = PageRequest.of(page,linesPerPae, Sort.Direction.valueOf(direction),orderBy);

        Page<ContratoDTO> pageList = service.findAllPaged(pageRequest);

        return ResponseEntity.ok().body(pageList);
    }
    @PostMapping
    public ResponseEntity<ContratoDTO> insert (@RequestBody ContratoDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContratoDTO> search(@PathVariable Long id) {

        ContratoDTO dto = service.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContratoDTO> update(@PathVariable Long id, @RequestBody ContratoDTO dto){
        dto = service.update(id,dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable Long id) {
        this.service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
