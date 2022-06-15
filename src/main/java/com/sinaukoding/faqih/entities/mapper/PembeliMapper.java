package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Pembeli;
import com.sinaukoding.faqih.entities.dto.PembeliDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembeliMapper {
    PembeliMapper INSTANCE = Mappers.getMapper(PembeliMapper.class);

    PembeliDTO toDto(Pembeli pembeli);
    List<PembeliDTO> toDtoList(List<Pembeli> pembeli);

    Pembeli toEntity(PembeliDTO pembeliDTO);
}
