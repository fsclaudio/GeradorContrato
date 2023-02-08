package com.cfs.gerador.contrato.services;

import com.cfs.gerador.contrato.dtos.ContratanteDTO;
import com.cfs.gerador.contrato.dtos.ContratoDTO;
import com.cfs.gerador.contrato.entities.Contratante;
import com.cfs.gerador.contrato.entities.Contrato;
import com.cfs.gerador.contrato.exceptions.ResourceNotFoundException;
import com.cfs.gerador.contrato.repositories.ContratanteRepository;
import com.cfs.gerador.contrato.repositories.ContratoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class ContratanteService {
    @Autowired
    private ContratanteRepository repository;

    @Transactional(readOnly = true)
    public Page<ContratanteDTO> findAllPaged(PageRequest pageRequest){

        Page<Contratante> list= repository.findAll( pageRequest);

        return list.map(x -> new ContratanteDTO(x));
    }

    @Transactional(readOnly = true)
    public ContratanteDTO findById(Long id) {
        Optional<Contratante> obj = repository.findById(id);
        Contratante contratante = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new ContratanteDTO(contratante);

    }

    @Transactional
    public ContratanteDTO insert(ContratanteDTO dto) {
        Contratante contratante = new Contratante();
        BeanUtils.copyProperties(dto,contratante,"id");

        contratante= repository.save(contratante);

        return new ContratanteDTO(contratante);
    }


    @Transactional
    public ContratanteDTO update(Long id, ContratanteDTO dto) {
            Contratante contratante = repository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado" + id));
            BeanUtils.copyProperties(dto,contratante,"id");
            contratante = repository.save(contratante);
            return new ContratanteDTO(contratante);
    }


    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("id not found " + id);
        }
    }
}
