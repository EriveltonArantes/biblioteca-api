package com.bibliotecaapi.service;

import com.bibliotecaapi.dto.AutorRequestDTO;
import com.bibliotecaapi.dto.AutorResponseDTO;
import com.bibliotecaapi.exception.ResourceNotFoundException;
import com.bibliotecaapi.mapper.AutorMapper;
import com.bibliotecaapi.model.Autor;
import com.bibliotecaapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AutorService {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private AutorMapper mapper;

    @Transactional(readOnly = true)
    public List<AutorResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AutorResponseDTO buscar(Long id) {
        Autor entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AutorResponseDTO criar(AutorRequestDTO dto) {
        Autor entity = mapper.toEntity(dto);
        Autor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AutorResponseDTO atualizar(Long id, AutorRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Autor não encontrado com id: " + id);
        }
        Autor entity = mapper.toEntity(dto);
        entity.setId(id);
        Autor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Autor não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
