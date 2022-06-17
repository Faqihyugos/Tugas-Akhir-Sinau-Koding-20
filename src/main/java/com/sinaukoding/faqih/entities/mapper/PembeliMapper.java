package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Pembeli;
import com.sinaukoding.faqih.entities.dto.PembeliDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembeliMapper {
    PembeliMapper INSTANCE = Mappers.getMapper(PembeliMapper.class);

    //    @mapping karena field entity dan entityDTO berbeda.
    @Mapping(source = "idPembeli", target = "id")
    @Mapping(source = "namaPembeli", target = "nama_pembeli")
    @Mapping(source = "noTelp", target = "no_telp")
    @Mapping(source = "alamat", target = "alamat")
    @Mapping(source = "listTransaksi", target = "list_transaksi")
    PembeliDTO toDto(Pembeli pembeli);
    List<PembeliDTO> toDtoList(List<Pembeli> pembeli);

    @Mapping(source = "id", target = "idPembeli")
    @Mapping(source = "nama_pembeli", target = "namaPembeli")
    @Mapping(source = "no_telp", target = "noTelp")
    @Mapping(source = "alamat", target = "alamat")
    @Mapping(source = "list_transaksi", target = "listTransaksi")
    Pembeli toEntity(PembeliDTO pembeliDTO);
}
