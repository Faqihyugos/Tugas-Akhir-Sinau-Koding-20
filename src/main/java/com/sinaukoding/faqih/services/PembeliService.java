package com.sinaukoding.faqih.services;

import com.sinaukoding.faqih.entities.Pembeli;
import com.sinaukoding.faqih.entities.dto.PembeliDTO;
import com.sinaukoding.faqih.entities.mapper.PembeliMapper;
import com.sinaukoding.faqih.repositories.PembeliRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembeliService {

    PembeliMapper pembeliMapper = PembeliMapper.INSTANCE;
    @Autowired
    PembeliRepo pembeliRepo;


    public PembeliDTO createPembeli(PembeliDTO pembeliDTO) {
        Pembeli pembeli = pembeliRepo.save(pembeliMapper.toEntity(pembeliDTO));
        return pembeliMapper.toDto(pembeli);
    }

    public List<PembeliDTO> getAllPembeli() {
        return pembeliMapper.toDtoList(pembeliRepo.findAll());
    }

    public PembeliDTO getPembeliById(Integer id) {
        return pembeliMapper.toDto(pembeliRepo.findById(id).get());
    }

    public List<PembeliDTO> getPembeliByName(String name) {
        return pembeliMapper.toDtoList(pembeliRepo.findByNamaPembeliContaining(name));
    }

    public PembeliDTO updatePembeli(Integer id, PembeliDTO pembeliDTO) {
        Pembeli reference = pembeliRepo.findById(id).get();
        reference.setNamaPembeli(pembeliDTO.getNama_pembeli() != null ? pembeliDTO.getNama_pembeli() : reference.getNamaPembeli());
        reference.setNoTelp(pembeliDTO.getNo_telp() != null ? pembeliDTO.getNo_telp() : reference.getNoTelp());
        reference.setAlamat(pembeliDTO.getAlamat() != null ? pembeliDTO.getAlamat() : reference.getAlamat());
        return pembeliMapper.toDto(pembeliRepo.save(reference));
    }

    public Boolean deletePembeli(Integer id) {
        Pembeli reference = pembeliRepo.findById(id).orElse(null);
        if (reference != null) {
            pembeliRepo.delete(reference);
            return true;
        } else {
            return false;
        }
    }
}
