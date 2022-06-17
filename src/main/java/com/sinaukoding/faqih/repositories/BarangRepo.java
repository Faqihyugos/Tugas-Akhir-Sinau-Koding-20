package com.sinaukoding.faqih.repositories;

import com.sinaukoding.faqih.entities.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarangRepo extends JpaRepository<Barang, Integer> {
    List<Barang> findByNamaBarangContaining(String nama);
}
