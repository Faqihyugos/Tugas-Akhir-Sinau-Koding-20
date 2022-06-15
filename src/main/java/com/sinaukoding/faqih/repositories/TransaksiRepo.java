package com.sinaukoding.faqih.repositories;

import com.sinaukoding.faqih.entities.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepo extends JpaRepository<Transaksi, Integer> {

}
