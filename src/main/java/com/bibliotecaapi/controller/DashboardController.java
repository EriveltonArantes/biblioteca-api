package com.bibliotecaapi.controller;

import com.bibliotecaapi.model.Autor;
import com.bibliotecaapi.model.Livro;
import com.bibliotecaapi.model.Leitor;
import com.bibliotecaapi.model.Emprestimo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.bibliotecaapi.repository.AutorRepository autorRepository;

    @Autowired
    private com.bibliotecaapi.repository.LivroRepository livroRepository;

    @Autowired
    private com.bibliotecaapi.repository.LeitorRepository leitorRepository;

    @Autowired
    private com.bibliotecaapi.repository.EmprestimoRepository emprestimoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalAutor", autorRepository.count());
        resumo.put("totalLivro", livroRepository.count());
        resumo.put("somaExemplaresLivro", livroRepository.findAll().stream().filter(e -> e.getExemplares() != null).mapToInt(e -> e.getExemplares()).sum());
        resumo.put("totalLeitor", leitorRepository.count());
        resumo.put("totalEmprestimo", emprestimoRepository.count());
        resumo.put("graficoEmprestimo", emprestimoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
