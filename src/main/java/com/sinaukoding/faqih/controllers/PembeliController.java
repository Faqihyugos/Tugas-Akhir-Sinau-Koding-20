package com.sinaukoding.faqih.controllers;

import com.sinaukoding.faqih.entities.dto.PembeliDTO;
import com.sinaukoding.faqih.services.PembeliService;
import com.sinaukoding.faqih.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {
    @Autowired
    private PembeliService pembeliService;

    @PostMapping
    public Response createPembeli(@RequestBody PembeliDTO pembeliDTO) {
        return new Response("Pembeli berhasil ditambahkan", HttpStatus.CREATED, pembeliService.createPembeli(pembeliDTO));
    }

    @GetMapping
    public Response getAllPembeli() {
        return new Response("Berhasil melihat semua pembeli", HttpStatus.OK, pembeliService.getAllPembeli());
    }

    @GetMapping("/find-name/")
    public Response getPembeliByName(@RequestParam String name) {
        List<PembeliDTO> data = pembeliService.getPembeliByName(name);
        return new Response(data != null ? "Berhasil mengambil pembeli berdasarkan nama": "Data tidak ada", HttpStatus.OK,data);
    }

    @GetMapping("/{id}")
    public Response getPembeliById(@PathVariable Integer id) {
        return new Response("Berhasil mengambil pembeli dengan id " + id, HttpStatus.OK, pembeliService.getPembeliById(id));
    }

    @PutMapping("/{id}")
    public Response updatePembeli(@PathVariable Integer id, @RequestBody PembeliDTO pembeliDTO) {
        return new Response("Berhasil mengubah pembeli dengan id " +id, HttpStatus.OK, pembeliService.updatePembeli(id,pembeliDTO));
    }

    @DeleteMapping("/{id}")
    public Response deletePembeli(@PathVariable Integer id) {
        if(pembeliService.deletePembeli(id)) {
            return new Response("Berhasil menghapus pembeli dengan id " + id, HttpStatus.OK);
        } else {
            return new Response("Pembeli dengan id " + id + " tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }
}
