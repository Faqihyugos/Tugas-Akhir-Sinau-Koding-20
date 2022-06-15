package com.sinaukoding.faqih.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(name = "tgl_pembayaran")
    private String tglPembayaran;

    @Column(name = "total_pembayaran")
    private Integer totalPembayaran;

    @OneToMany(mappedBy = "pembayaran", fetch = FetchType.LAZY)
    private List<Transaksi> listTransaksi = new ArrayList<>();
}
