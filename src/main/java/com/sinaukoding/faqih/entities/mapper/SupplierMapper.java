package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Supplier;
import com.sinaukoding.faqih.entities.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);
    @Mapping(source = "idSupplier", target = "id")
    @Mapping(source = "namaSupplier", target = "nama_supplier")
    @Mapping(source = "noTelp", target = "no_telp")
    @Mapping(source = "listBarang", target = "list_barang")
    SupplierDTO toDto(Supplier supplier);

    List<SupplierDTO> toDtoList(List<Supplier> supplier);

//    @mapping karena field entity supplier dan entityDTO berbeda.
    @Mapping(source = "id", target = "idSupplier")
    @Mapping(source = "nama_supplier", target = "namaSupplier")
    @Mapping(source = "no_telp", target = "noTelp")
    @Mapping(source = "list_barang", target = "listBarang")
    Supplier toEntity(SupplierDTO supplierDTO);
}
