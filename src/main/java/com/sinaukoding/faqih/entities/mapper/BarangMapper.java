package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Barang;
import com.sinaukoding.faqih.entities.dto.BarangDTO;
import com.sinaukoding.faqih.entities.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BarangMapper {
    BarangMapper INSTANCE = Mappers.getMapper(BarangMapper.class);

    //    @mapping karena field entity supplier dan entityDTO berbeda.
    @Mapping(source = "idBarang", target = "id")
    @Mapping(source = "namaBarang", target = "nama_barang")
    @Mapping(source = "hargaBarang", target = "harga_barang")
    @Mapping(source = "stokBarang", target = "stok_barang")
    @Mapping(source = "supplier", target = "data_supplier")
    BarangDTO toDto(Barang barang);
    List<BarangDTO> toDtoList(List<Barang> barang);

    @Mapping(source = "id", target = "idBarang")
    @Mapping(source = "nama_barang", target = "namaBarang")
    @Mapping(source = "harga_barang", target = "hargaBarang")
    @Mapping(source = "stok_barang", target = "stokBarang")
    @Mapping(source = "data_supplier", target = "supplier")
    Barang toEntity(BarangDTO barangDTO);
}
