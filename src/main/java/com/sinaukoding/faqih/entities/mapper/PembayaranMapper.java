package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Pembayaran;
import com.sinaukoding.faqih.entities.dto.PembayaranDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembayaranMapper {
 PembayaranMapper INSTANCE = Mappers.getMapper(PembayaranMapper.class);

 PembayaranDTO toDto(Pembayaran pembayaran);
 List<PembayaranDTO> toDtoList(List<Pembayaran> pembayaran);

 Pembayaran toEntity(PembayaranDTO pembayaranDTO);
}
