package com.bibliotecaapi.service;

import com.bibliotecaapi.dto.LivroRequestDTO;
import com.bibliotecaapi.dto.LivroResponseDTO;
import com.bibliotecaapi.exception.ResourceNotFoundException;
import com.bibliotecaapi.mapper.LivroMapper;
import com.bibliotecaapi.model.Livro;
import com.bibliotecaapi.repository.LivroRepository;
import com.bibliotecaapi.repository.AutorRepository;
import com.bibliotecaapi.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private LivroMapper mapper;

    @Autowired
    private AutorRepository autorRepository;

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LivroResponseDTO buscar(Long id) {
        Livro entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public LivroResponseDTO criar(LivroRequestDTO dto) {
        Livro entity = mapper.toEntity(dto);
        Autor autor = autorRepository.findById(dto.getAutorId())
            .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado com id: " + dto.getAutorId()));
        entity.setAutor(autor);
        Livro salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Livro não encontrado com id: " + id);
        }
        Livro entity = mapper.toEntity(dto);
        entity.setId(id);
        Autor autor = autorRepository.findById(dto.getAutorId())
            .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado com id: " + dto.getAutorId()));
        entity.setAutor(autor);
        Livro salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Livro não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
