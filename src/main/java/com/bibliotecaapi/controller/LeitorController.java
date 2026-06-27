package com.bibliotecaapi.controller;

import com.bibliotecaapi.dto.LeitorRequestDTO;
import com.bibliotecaapi.dto.LeitorResponseDTO;
import com.bibliotecaapi.service.LeitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Leitor", description = "Gerenciamento de leitors")
@RestController
@RequestMapping("/api/leitors")
public class LeitorController {

    @Autowired
    private LeitorService service;

    @Operation(summary = "Listar todos os Leitor")
    @GetMapping
    public List<LeitorResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<LeitorResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Leitor por ID")
    @GetMapping("/{id}")
    public LeitorResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Leitor")
    @PostMapping
    public ResponseEntity<LeitorResponseDTO> criar(@Valid @RequestBody LeitorRequestDTO leitor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(leitor));
    }

    @Operation(summary = "Atualizar Leitor")
    @PutMapping("/{id}")
    public LeitorResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody LeitorRequestDTO leitor) {
        return service.atualizar(id, leitor);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Leitor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
