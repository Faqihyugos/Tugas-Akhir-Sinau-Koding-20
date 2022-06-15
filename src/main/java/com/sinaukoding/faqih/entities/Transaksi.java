package com.sinaukoding.faqih.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaksi")
@Getter
@Setter
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Integer idTransaksi;

    @JsonIgnoreProperties(value = {"listBarang","hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @JsonIgnoreProperties(value = {"listTransaksi","hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    @JsonIgnoreProperties(value = {"listTransaksi","hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pembayaran")
    private Pembayaran pembayaran;

    @Column(name = "tgl_transaksi")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglTransaksi;

    @Column(name = "keterangan")
    private String keterangan;
}
