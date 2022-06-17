package com.sinaukoding.faqih.services;

import com.sinaukoding.faqih.entities.Pembayaran;
import com.sinaukoding.faqih.entities.dto.PembayaranDTO;
import com.sinaukoding.faqih.entities.mapper.PembayaranMapper;
import com.sinaukoding.faqih.repositories.PembayaranRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranService {
    PembayaranMapper pembayaranMapper = PembayaranMapper.INSTANCE;
    @Autowired
    PembayaranRepo pembayaranRepo;

    // create pembayaran
    public PembayaranDTO createPembayaran(PembayaranDTO pembayaranDTO) {
        Pembayaran pembayaran = pembayaranRepo.save(pembayaranMapper.toEntity(pembayaranDTO));
        return pembayaranMapper.toDto(pembayaran);
    }

    // get all pembayaran
    public List<PembayaranDTO> getAllPembayaran() {
        return pembayaranMapper.toDtoList(pembayaranRepo.findAll());
    }

    // get by id pembayaran
    public PembayaranDTO getPembayaranById(Integer id) {
        return pembayaranMapper.toDto(pembayaranRepo.findById(id).get());
    }

    // update pembayaran
    public PembayaranDTO updatePembayaran(Integer id, PembayaranDTO pembayaranDTO) {
        Pembayaran reference = pembayaranRepo.findById(id).get();
        reference.setTglPembayaran(pembayaranDTO.getTgl_pembayaran() != null ? pembayaranDTO.getTgl_pembayaran(): reference.getTglPembayaran());
        reference.setTotalPembayaran(pembayaranDTO.getTotal_bayar() != null ? pembayaranDTO.getTotal_bayar(): reference.getTotalPembayaran());
        return pembayaranMapper.toDto(pembayaranRepo.save(reference));
    }

    public Boolean deletePembayaran(Integer id) {
        Pembayaran reference = pembayaranRepo.findById(id).orElse(null);
        if (reference != null) {
            pembayaranRepo.delete(reference);
            return true;
        } else {
            return false;
        }
    }

}
