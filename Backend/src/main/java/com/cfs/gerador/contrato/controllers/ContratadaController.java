package com.cfs.gerador.contrato.controllers;

import com.cfs.gerador.contrato.dtos.ContratadaDTO;
import com.cfs.gerador.contrato.dtos.ContratoDTO;
import com.cfs.gerador.contrato.services.ContratadaService;
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
@CrossOrigin("*")
@RequestMapping("/contratadas")
public class ContratadaController {

    @Autowired
    private ContratadaService service;

    @GetMapping
    public ResponseEntity<Page<ContratadaDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerpage", defaultValue = "12") Integer linesPerPae,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "razaoSocialContratada") String orderBy
    ){

        PageRequest pageRequest = PageRequest.of(page,linesPerPae, Sort.Direction.valueOf(direction),orderBy);

        Page<ContratadaDTO> pageList = service.findAllPaged(pageRequest);

        return ResponseEntity.ok().body(pageList);
    }
    @PostMapping
    public ResponseEntity<ContratadaDTO> insert (@RequestBody ContratadaDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContratadaDTO> search(@PathVariable Long id) {

        ContratadaDTO dto = service.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContratadaDTO> update(@PathVariable Long id, @RequestBody ContratadaDTO dto){
        dto = service.update(id,dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable Long id) {
        this.service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
