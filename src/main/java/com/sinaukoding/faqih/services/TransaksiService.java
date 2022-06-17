package com.sinaukoding.faqih.services;

import com.sinaukoding.faqih.entities.Transaksi;
import com.sinaukoding.faqih.entities.dto.TransaksiDTO;
import com.sinaukoding.faqih.entities.mapper.TransaksiMapper;
import com.sinaukoding.faqih.repositories.TransaksiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {

    TransaksiMapper transaksiMapper = TransaksiMapper.INSTANCE;
    @Autowired
    TransaksiRepo transaksiRepo;

    // create Transaksi
    public TransaksiDTO createTransaksi(TransaksiDTO transaksiDTO) {
        Transaksi transaksi = transaksiRepo.save(transaksiMapper.toEntity(transaksiDTO));
        return transaksiMapper.toDto(transaksi);
    }

    // get all Transaksi
    public List<TransaksiDTO> getAllTransaksi() {
        return transaksiMapper.toDtoList(transaksiRepo.findAll());
    }

    // get Transaksi by id
    public TransaksiDTO getTransaksiById(Integer id) {
        return transaksiMapper.toDto(transaksiRepo.findById(id).get());
    }

    // update Transaksi
    public TransaksiDTO updateTransaksi(Integer id, TransaksiDTO transaksiDTO) {
        Transaksi reference = transaksiRepo.findById(id).get();
        reference.setBarang(transaksiDTO.getBarang() != null ? transaksiDTO.getBarang() : reference.getBarang());
        reference.setPembeli(transaksiDTO.getPembeli() != null ? transaksiDTO.getPembeli() : reference.getPembeli());
        reference.setPembayaran(transaksiDTO.getPembayaran() != null ? transaksiDTO.getPembayaran() : reference.getPembayaran());
        reference.setKeterangan(transaksiDTO.getKeterangan() != null ? transaksiDTO.getKeterangan() : reference.getKeterangan());
        reference.setTglTransaksi(transaksiDTO.getTgl_transaksi() != null ? transaksiDTO.getTgl_transaksi() : reference.getTglTransaksi());
        return transaksiMapper.toDto(transaksiRepo.save(reference));
    }

    // delete Transaksi
    public Boolean deleteTransaksi(Integer id) {
        Transaksi reference = transaksiRepo.findById(id).orElse(null);
        if (reference != null) {
            transaksiRepo.delete(reference);
            return true;
        } else {
            return false;
        }
    }
}
