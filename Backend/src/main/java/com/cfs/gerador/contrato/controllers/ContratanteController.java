package com.cfs.gerador.contrato.controllers;

import com.cfs.gerador.contrato.dtos.ContratanteDTO;
import com.cfs.gerador.contrato.dtos.ContratoDTO;
import com.cfs.gerador.contrato.services.ContratanteService;
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
@RequestMapping("/contratates")
public class ContratanteController {

    @Autowired
    private ContratanteService service;

    @GetMapping
    public ResponseEntity<Page<ContratanteDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerpage", defaultValue = "12") Integer linesPerPae,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "razaoSocialContratante") String orderBy
    ){

        PageRequest pageRequest = PageRequest.of(page,linesPerPae, Sort.Direction.valueOf(direction),orderBy);

        Page<ContratanteDTO> pageList = service.findAllPaged(pageRequest);

        return ResponseEntity.ok().body(pageList);
    }
    @PostMapping
    public ResponseEntity<ContratanteDTO> insert (@RequestBody ContratanteDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContratanteDTO> search(@PathVariable Long id) {

        ContratanteDTO dto = service.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContratanteDTO> update(@PathVariable Long id, @RequestBody ContratanteDTO dto){
        dto = service.update(id,dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable Long id) {
        this.service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
