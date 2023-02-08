package com.cfs.gerador.contrato.services;

import com.cfs.gerador.contrato.dtos.ContratadaDTO;
import com.cfs.gerador.contrato.dtos.ContratanteDTO;
import com.cfs.gerador.contrato.entities.Contratada;
import com.cfs.gerador.contrato.entities.Contratante;
import com.cfs.gerador.contrato.exceptions.ResourceNotFoundException;
import com.cfs.gerador.contrato.repositories.ContratadaRepository;
import com.cfs.gerador.contrato.repositories.ContratanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ContratadaService {
    @Autowired
    private ContratadaRepository repository;

    @Transactional(readOnly = true)
    public Page<ContratadaDTO> findAllPaged(PageRequest pageRequest){

        Page<Contratada> list= repository.findAll( pageRequest);

        return list.map(x -> new ContratadaDTO(x));
    }

    @Transactional(readOnly = true)
    public ContratadaDTO findById(Long id) {
        Optional<Contratada> obj = repository.findById(id);
        Contratada contratada = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new ContratadaDTO(contratada);

    }

    @Transactional
    public ContratadaDTO insert(ContratadaDTO dto) {
        Contratada contratada = new Contratada();
        BeanUtils.copyProperties(dto,contratada,"id");

        contratada= repository.save(contratada);

        return new ContratadaDTO(contratada);
    }


    @Transactional
    public ContratadaDTO update(Long id, ContratadaDTO dto) {
            Contratada contratada = repository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado" + id));
            BeanUtils.copyProperties(dto,contratada,"id");
            contratada = repository.save(contratada);
            return new ContratadaDTO(contratada);
    }


    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("id not found " + id);
        }
    }
}
