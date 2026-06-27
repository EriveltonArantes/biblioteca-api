package com.bibliotecaapi.controller;

import com.bibliotecaapi.dto.AutorRequestDTO;
import com.bibliotecaapi.dto.AutorResponseDTO;
import com.bibliotecaapi.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Autor", description = "Gerenciamento de autors")
@RestController
@RequestMapping("/api/autors")
public class AutorController {

    @Autowired
    private AutorService service;

    @Operation(summary = "Listar todos os Autor")
    @GetMapping
    public List<AutorResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<AutorResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Autor por ID")
    @GetMapping("/{id}")
    public AutorResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Autor")
    @PostMapping
    public ResponseEntity<AutorResponseDTO> criar(@Valid @RequestBody AutorRequestDTO autor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(autor));
    }

    @Operation(summary = "Atualizar Autor")
    @PutMapping("/{id}")
    public AutorResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody AutorRequestDTO autor) {
        return service.atualizar(id, autor);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Autor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
