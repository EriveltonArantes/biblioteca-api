package com.bibliotecaapi.mapper;

import com.bibliotecaapi.dto.AutorRequestDTO;
import com.bibliotecaapi.dto.AutorResponseDTO;
import com.bibliotecaapi.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    Autor toEntity(AutorRequestDTO dto);

    AutorResponseDTO toResponseDTO(Autor entity);
}
