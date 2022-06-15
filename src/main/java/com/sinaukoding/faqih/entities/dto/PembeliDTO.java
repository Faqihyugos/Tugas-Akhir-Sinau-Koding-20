package com.sinaukoding.faqih.entities.dto;

import com.sinaukoding.faqih.entities.Transaksi;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PembeliDTO {
    private Integer id;

    private String nama_pembeli;

    private String no_telp;

    private String alamat;

    private List<Transaksi> list_transaksi = new ArrayList<>();
}
