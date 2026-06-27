package com.bibliotecaapi.service;

import com.bibliotecaapi.dto.EmprestimoRequestDTO;
import com.bibliotecaapi.dto.EmprestimoResponseDTO;
import com.bibliotecaapi.exception.ResourceNotFoundException;
import com.bibliotecaapi.mapper.EmprestimoMapper;
import com.bibliotecaapi.model.Emprestimo;
import com.bibliotecaapi.repository.EmprestimoRepository;
import com.bibliotecaapi.repository.LivroRepository;
import com.bibliotecaapi.model.Livro;
import com.bibliotecaapi.repository.LeitorRepository;
import com.bibliotecaapi.model.Leitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private EmprestimoMapper mapper;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LeitorRepository leitorRepository;

    @Transactional(readOnly = true)
    public List<EmprestimoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmprestimoResponseDTO buscar(Long id) {
        Emprestimo entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Emprestimo não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EmprestimoResponseDTO criar(EmprestimoRequestDTO dto) {
        Emprestimo entity = mapper.toEntity(dto);
        Livro livro = livroRepository.findById(dto.getLivroId())
            .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com id: " + dto.getLivroId()));
        entity.setLivro(livro);
        Leitor leitor = leitorRepository.findById(dto.getLeitorId())
            .orElseThrow(() -> new ResourceNotFoundException("Leitor não encontrado com id: " + dto.getLeitorId()));
        entity.setLeitor(leitor);
        Emprestimo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EmprestimoResponseDTO atualizar(Long id, EmprestimoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Emprestimo não encontrado com id: " + id);
        }
        Emprestimo entity = mapper.toEntity(dto);
        entity.setId(id);
        Livro livro = livroRepository.findById(dto.getLivroId())
            .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com id: " + dto.getLivroId()));
        entity.setLivro(livro);
        Leitor leitor = leitorRepository.findById(dto.getLeitorId())
            .orElseThrow(() -> new ResourceNotFoundException("Leitor não encontrado com id: " + dto.getLeitorId()));
        entity.setLeitor(leitor);
        Emprestimo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Emprestimo não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
