package com.bibliotecaapi.mapper;

import com.bibliotecaapi.dto.LivroRequestDTO;
import com.bibliotecaapi.dto.LivroResponseDTO;
import com.bibliotecaapi.model.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    @Mapping(target = "autor", ignore = true)
    Livro toEntity(LivroRequestDTO dto);

    @Mapping(target = "autorId", source = "autor.id")
    LivroResponseDTO toResponseDTO(Livro entity);
}
