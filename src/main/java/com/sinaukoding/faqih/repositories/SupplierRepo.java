package com.sinaukoding.faqih.repositories;

import com.sinaukoding.faqih.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
    List<Supplier> findByNamaSupplierContaining(String nama);
}
