package com.sinaukoding.faqih.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pembayaran")
@Getter
@Setter
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pembayaran")
    private Integer idPembayaran;

    @Column(name = "tgl_bayar")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglPembayaran;

    @Column(name = "total")
    private Double totalPembayaran;

    @OneToMany(mappedBy = "pembayaran", fetch = FetchType.LAZY)
    private List<Transaksi> listTransaksi = new ArrayList<>();
}
