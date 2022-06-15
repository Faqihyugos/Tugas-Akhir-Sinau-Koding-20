package com.sinaukoding.faqih.entities.dto;

import com.sinaukoding.faqih.entities.Transaksi;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PembayaranDTO {
    private Integer id;

    private String tgl_pembayaran;

    private Integer total_bayar;

    private List<Transaksi> list_transaksi = new ArrayList<>();
}
