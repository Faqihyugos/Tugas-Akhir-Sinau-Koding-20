package com.sinaukoding.faqih.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinaukoding.faqih.entities.Transaksi;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PembayaranDTO {
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tgl_pembayaran;

    private Double total_bayar;

    private List<Transaksi> list_transaksi = new ArrayList<>();
}
