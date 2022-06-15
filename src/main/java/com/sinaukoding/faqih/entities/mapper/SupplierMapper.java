package com.sinaukoding.faqih.entities.mapper;

import com.sinaukoding.faqih.entities.Supplier;
import com.sinaukoding.faqih.entities.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierDTO toDto(Supplier supplier);
    List<SupplierDTO> toDtoList(List<Supplier> supplier);

    Supplier toEntity(SupplierDTO supplierDTO);
}
