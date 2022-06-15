package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Barang;
import com.sinaukoding.faqih.entities.dto.BarangDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BarangMapper {
    BarangMapper INSTANCE = Mappers.getMapper(BarangMapper.class);

    BarangDTO toDto(Barang barang);
    List<BarangDTO> toDtoList(List<Barang> barang);

    Barang toEntity(BarangDTO barangDTO);
}
