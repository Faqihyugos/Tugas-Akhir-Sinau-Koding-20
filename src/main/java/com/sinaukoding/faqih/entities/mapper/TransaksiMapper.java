package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Transaksi;
import com.sinaukoding.faqih.entities.dto.TransaksiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapper {
    TransaksiMapper INSTANCE = Mappers.getMapper(TransaksiMapper.class);

    TransaksiDTO toDto(Transaksi transaksi);
    List<TransaksiDTO> toDtoList(List<Transaksi> transaksi);

    Transaksi toEntity(TransaksiDTO transaksiDTO);
}
