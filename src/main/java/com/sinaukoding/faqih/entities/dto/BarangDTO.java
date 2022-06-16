package com.sinaukoding.faqih.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sinaukoding.faqih.entities.Supplier;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BarangDTO {
    private Integer id;

    private String nama_barang;

    private Integer harga_barang;

    private Integer stok_barang;

    @JsonIgnoreProperties(value = {"listBarang","handler","hibernateLazyInitializer"}, allowSetters = true)
    private Supplier data_supplier;
}
