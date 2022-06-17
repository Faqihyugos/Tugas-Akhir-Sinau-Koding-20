package com.sinaukoding.faqih.repositories;

import com.sinaukoding.faqih.entities.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PembeliRepo extends JpaRepository<Pembeli, Integer> {
    List<Pembeli> findByNamaPembeliContaining(String nama);
}
