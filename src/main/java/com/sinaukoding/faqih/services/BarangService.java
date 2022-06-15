package com.sinaukoding.faqih.services;

import com.sinaukoding.faqih.entities.Barang;
import com.sinaukoding.faqih.entities.dto.BarangDTO;
import com.sinaukoding.faqih.entities.mapper.BarangMapper;
import com.sinaukoding.faqih.repositories.BarangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {
    @Autowired
    BarangRepo barangRepo;

    // create barang
    public BarangDTO createBarang(BarangDTO barangDTO) {
        Barang barang = barangRepo.save(BarangMapper.INSTANCE.toEntity(barangDTO));
        return BarangMapper.INSTANCE.toDto(barang);
    }

    // get all barang
    public List<BarangDTO> getAllBarang() {
        return BarangMapper.INSTANCE.toDtoList(barangRepo.findAll());
    }

    // get barang by id
    public BarangDTO getBarangById(Integer id) {
        return BarangMapper.INSTANCE.toDto(barangRepo.findById(id).get());
    }

    // update barang
    public BarangDTO updateBarang(Integer id, BarangDTO barangDTO) {
        Barang barang = barangRepo.findById(id).get();
        barang.setNamaBarang(barangDTO.getNama_barang() != null ? barangDTO.getNama_barang() : barang.getNamaBarang());
        barang.setHargaBarang(barangDTO.getHarga_barang() != null ? barangDTO.getHarga_barang() : barang.getHargaBarang());
        barang.setStokBarang(barangDTO.getStok_barang() != null ? barangDTO.getStok_barang() : barang.getStokBarang());
        return BarangMapper.INSTANCE.toDto(barangRepo.save(barang));
    }

    // delete barang
    public Boolean deleteBarang(Integer id) {
        Barang reference = barangRepo.findById(id).orElse(null);
        if (reference != null) {
            barangRepo.delete(reference);
            return true;
        } else {
            return false;
        }
    }
}
