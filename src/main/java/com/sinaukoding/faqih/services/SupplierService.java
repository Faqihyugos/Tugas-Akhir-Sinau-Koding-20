package com.sinaukoding.faqih.services;

import com.sinaukoding.faqih.entities.Supplier;
import com.sinaukoding.faqih.entities.dto.SupplierDTO;
import com.sinaukoding.faqih.entities.mapper.SupplierMapper;
import com.sinaukoding.faqih.repositories.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepo supplierRepo;

    // create supplier
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepo.save(SupplierMapper.INSTANCE.toEntity(supplierDTO));
        return SupplierMapper.INSTANCE.toDto(supplier);
    }

    // get all supplier
    public List<SupplierDTO> getAllSupplier() {
        return SupplierMapper.INSTANCE.toDtoList(supplierRepo.findAll());
    }

    // get supplier by name
    public List<SupplierDTO> getSupplierByName(String name) {
        return SupplierMapper.INSTANCE.toDtoList(supplierRepo.findByNamaSupplierContaining(name));
    }

    // update supplier
    public SupplierDTO updateSupplier(Integer id, SupplierDTO supplierDTO) {
        Supplier reference = supplierRepo.findById(id).get();
        reference.setNamaSupplier(supplierDTO.getNama_supplier() != null ? supplierDTO.getNama_supplier(): reference.getNamaSupplier());
        reference.setNoTelp(supplierDTO.getNo_telp() != null ? supplierDTO.getNo_telp() : reference.getNoTelp());
        reference.setAlamat(supplierDTO.getAlamat() != null ? supplierDTO.getAlamat() : reference.getAlamat());
        return SupplierMapper.INSTANCE.toDto(supplierRepo.save(reference));
    }

    public Boolean deleteSupplier(Integer id) {
        Supplier reference = supplierRepo.findById(id).orElse(null);
        if (reference != null) {
            supplierRepo.delete(reference);
            return true;
        } else {
            return false;
        }
    }
}
