package com.sinaukoding.faqih.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sinaukoding.faqih.entities.Barang;
import com.sinaukoding.faqih.entities.Pembayaran;
import com.sinaukoding.faqih.entities.Pembeli;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransaksiDTO {
    private Integer id;

    @JsonIgnoreProperties(value = {"list_barang","hibernateLazyInitializer", "handler"}, allowSetters = true)
    private Barang barang;

    @JsonIgnoreProperties(value = {"list_transaksi","hibernateLazyInitializer", "handler"}, allowSetters = true)
    private Pembeli pembeli;

    @JsonIgnoreProperties(value = {"list_transaksi","hibernateLazyInitializer", "handler"}, allowSetters = true)
    private Pembayaran pembayaran;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String tgl_transaksi;

    private String keterangan;
}
