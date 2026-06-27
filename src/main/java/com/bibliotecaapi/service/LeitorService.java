package com.bibliotecaapi.service;

import com.bibliotecaapi.dto.LeitorRequestDTO;
import com.bibliotecaapi.dto.LeitorResponseDTO;
import com.bibliotecaapi.exception.ResourceNotFoundException;
import com.bibliotecaapi.mapper.LeitorMapper;
import com.bibliotecaapi.model.Leitor;
import com.bibliotecaapi.repository.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LeitorService {

    @Autowired
    private LeitorRepository repository;

    @Autowired
    private LeitorMapper mapper;

    @Transactional(readOnly = true)
    public List<LeitorResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LeitorResponseDTO buscar(Long id) {
        Leitor entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Leitor não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public LeitorResponseDTO criar(LeitorRequestDTO dto) {
        Leitor entity = mapper.toEntity(dto);
        Leitor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public LeitorResponseDTO atualizar(Long id, LeitorRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Leitor não encontrado com id: " + id);
        }
        Leitor entity = mapper.toEntity(dto);
        entity.setId(id);
        Leitor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Leitor não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
