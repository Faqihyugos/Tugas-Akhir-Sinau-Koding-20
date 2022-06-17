package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Transaksi;
import com.sinaukoding.faqih.entities.dto.TransaksiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapper {
    TransaksiMapper INSTANCE = Mappers.getMapper(TransaksiMapper.class);

    @Mapping(source = "idTransaksi", target = "id")
    @Mapping(source = "tglTransaksi", target = "tgl_transaksi")
    TransaksiDTO toDto(Transaksi transaksi);
    List<TransaksiDTO> toDtoList(List<Transaksi> transaksi);

    @Mapping(source = "id", target = "idTransaksi")
    @Mapping(source = "tgl_transaksi", target = "tglTransaksi")
    Transaksi toEntity(TransaksiDTO transaksiDTO);
}
