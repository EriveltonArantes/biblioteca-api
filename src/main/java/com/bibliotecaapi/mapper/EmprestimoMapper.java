package com.bibliotecaapi.mapper;

import com.bibliotecaapi.dto.EmprestimoRequestDTO;
import com.bibliotecaapi.dto.EmprestimoResponseDTO;
import com.bibliotecaapi.model.Emprestimo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmprestimoMapper {

    @Mapping(target = "livro", ignore = true)
    @Mapping(target = "leitor", ignore = true)
    Emprestimo toEntity(EmprestimoRequestDTO dto);

    @Mapping(target = "livroId", source = "livro.id")
    @Mapping(target = "leitorId", source = "leitor.id")
    EmprestimoResponseDTO toResponseDTO(Emprestimo entity);
}
