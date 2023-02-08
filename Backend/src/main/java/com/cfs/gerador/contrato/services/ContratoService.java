package com.cfs.gerador.contrato.services;

import com.cfs.gerador.contrato.dtos.ContratoDTO;
import com.cfs.gerador.contrato.entities.Contratada;
import com.cfs.gerador.contrato.entities.Contratante;
import com.cfs.gerador.contrato.entities.Contrato;
import com.cfs.gerador.contrato.exceptions.ResourceNotFoundException;
import com.cfs.gerador.contrato.repositories.ContratadaRepository;
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
public class ContratoService {
    @Autowired
    private ContratoRepository repository;

    @Autowired
    private ContratanteRepository contratanteRepository;

    @Autowired
    private ContratadaRepository contratadaRepository;

    @Transactional(readOnly = true)
    public Page<ContratoDTO> findAllPaged(PageRequest pageRequest){

        Page<Contrato> list= repository.findAll( pageRequest);

        return list.map(x -> new ContratoDTO(x));
    }

    @Transactional(readOnly = true)
    public ContratoDTO findById(Long id) {
        Optional<Contrato> obj = repository.findById(id);
        Contrato contrato = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new ContratoDTO(contrato);

    }

    @Transactional
    public ContratoDTO insert(ContratoDTO dto) {
        Contrato contrato = new Contrato();
        BeanUtils.copyProperties(dto,contrato,"id");
        contrato.setDataAbertura(new Date());
        Date dt = new Date();
        Contratada contratada = contratadaRepository.findById(dto.getContratada().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Registro não existe" + dto.getContratada().getId()));

        Contratante contratante = contratanteRepository.findById(dto.getContratante().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Registro não existe" + dto.getContratante().getId()));
        contrato.setContratada(contratada);
        contrato.setContratante(contratante);
        contrato.setDataTermino(dt);
        contrato.setDiaVencimentoParcela(dt.getDay());
        contrato= repository.save(contrato);

        return new ContratoDTO(contrato);
    }


    @Transactional
    public ContratoDTO update(Long id, ContratoDTO dto) {
            Contrato contrato = repository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado" + id));
            BeanUtils.copyProperties(dto,contrato,"id");
            contrato = repository.save(contrato);
            return new ContratoDTO(contrato);
    }


    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("id not found " + id);
        }
    }
}
