package com.sinaukoding.faqih.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sinaukoding.faqih.entities.dto.SupplierDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "barang")
@Getter
@Setter
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barang")
    private Integer idBarang;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga_barang")
    private Integer hargaBarang;

    @Column(name = "stok_barang")
    private Integer stokBarang;

    @JsonIgnoreProperties(value = {"listBarang","hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;
}
