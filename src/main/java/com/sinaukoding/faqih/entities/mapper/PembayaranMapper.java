package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Pembayaran;
import com.sinaukoding.faqih.entities.dto.PembayaranDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembayaranMapper {
 PembayaranMapper INSTANCE = Mappers.getMapper(PembayaranMapper.class);

 //    @mapping karena field entity supplier dan entityDTO berbeda.
 @Mapping(source = "idPembayaran", target = "id")
 @Mapping(source = "tglPembayaran", target = "tgl_pembayaran")
 @Mapping(source = "totalPembayaran", target = "total_bayar")
 @Mapping(source = "listTransaksi", target = "list_transaksi")
 PembayaranDTO toDto(Pembayaran pembayaran);
 List<PembayaranDTO> toDtoList(List<Pembayaran> pembayaran);

 @Mapping(source = "id", target = "idPembayaran")
 @Mapping(source = "tgl_pembayaran", target = "tglPembayaran")
 @Mapping(source = "total_bayar", target = "totalPembayaran")
 @Mapping(source = "list_transaksi", target = "listTransaksi")
 Pembayaran toEntity(PembayaranDTO pembayaranDTO);
}
