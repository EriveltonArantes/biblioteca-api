package com.bibliotecaapi.mapper;

import com.bibliotecaapi.dto.LeitorRequestDTO;
import com.bibliotecaapi.dto.LeitorResponseDTO;
import com.bibliotecaapi.model.Leitor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LeitorMapper {

    Leitor toEntity(LeitorRequestDTO dto);

    LeitorResponseDTO toResponseDTO(Leitor entity);
}
