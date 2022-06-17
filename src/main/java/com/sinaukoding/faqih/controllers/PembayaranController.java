package com.sinaukoding.faqih.controllers;

import com.sinaukoding.faqih.entities.dto.PembayaranDTO;
import com.sinaukoding.faqih.services.PembayaranService;
import com.sinaukoding.faqih.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {
    @Autowired
    PembayaranService pembayaranService;

    @PostMapping
    public Response createPembayaran(@RequestBody PembayaranDTO pembayaranDTO) {
        return new Response("Pembayaran berhasil ditambahkan", HttpStatus.CREATED, pembayaranService.createPemabayaran(pembayaranDTO));
    }

    @GetMapping("/{id}")
    public Response getPembayaranById(@PathVariable Integer id) {
        return new Response("Berhasil mengambil pembayaran dengan id " + id, HttpStatus.OK, pembayaranService.getPembayaranById(id));
    }

    @GetMapping
    public Response getAllPembayaran() {
        return new Response("Berhasil melihat semua pembayaran", HttpStatus.OK, pembayaranService.getAllPembayaran());
    }

    @PutMapping("/{id}")
    public Response updatePembayaran(@PathVariable Integer id, @RequestBody PembayaranDTO pembayaranDTO) {
        return new Response("Berhasil mengubah pembayaran dengan id " +id, HttpStatus.OK, pembayaranService.updatePembayaran(id,pembayaranDTO));
    }

    @DeleteMapping("/{id}")
    public Response deletePembayaran(@PathVariable Integer id) {
        if(pembayaranService.deletePembayaran(id)) {
            return new Response("Berhasil menghapus pembayaran dengan id " + id, HttpStatus.OK);
        } else {
            return new Response("Pembayaran dengan id " + id + " tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }
}
