package com.sinaukoding.faqih.entities.dto;

import com.sinaukoding.faqih.entities.Barang;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SupplierDTO {
    private Integer id;

    private String nama_supplier;

    private String no_telp;

    private String alamat;

    private List<Barang> list_barang = new ArrayList<>();
}
