package com.bibliotecaapi.controller;

import com.bibliotecaapi.dto.LivroRequestDTO;
import com.bibliotecaapi.dto.LivroResponseDTO;
import com.bibliotecaapi.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Livro", description = "Gerenciamento de livros")
@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @Operation(summary = "Listar todos os Livro")
    @GetMapping
    public List<LivroResponseDTO> listar(@RequestParam(required = false) String titulo, @RequestParam(required = false) Long autorId) {
        List<LivroResponseDTO> resultado = service.listar();
        if (titulo != null && !titulo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTitulo() != null &&
                item.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (autorId != null) {
            resultado = resultado.stream().filter(item -> autorId.equals(item.getAutorId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Livro por ID")
    @GetMapping("/{id}")
    public LivroResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Livro")
    @PostMapping
    public ResponseEntity<LivroResponseDTO> criar(@Valid @RequestBody LivroRequestDTO livro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(livro));
    }

    @Operation(summary = "Atualizar Livro")
    @PutMapping("/{id}")
    public LivroResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody LivroRequestDTO livro) {
        return service.atualizar(id, livro);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Livro")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
