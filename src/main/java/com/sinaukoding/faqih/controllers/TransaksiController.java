package com.sinaukoding.faqih.controllers;


import com.sinaukoding.faqih.entities.dto.TransaksiDTO;
import com.sinaukoding.faqih.services.TransaksiService;
import com.sinaukoding.faqih.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @PostMapping
    public Response createTransaksi(@RequestBody TransaksiDTO transaksiDTO) {
        return new Response("Transaksi berhasil ditambahkan", HttpStatus.CREATED, transaksiService.createTransaksi(transaksiDTO));
    }

    @GetMapping("/{id}")
    public Response getTransaksiById(@PathVariable Integer id) {
        return new Response("Berhasil mengambil transaksi dengan id " + id, HttpStatus.OK, transaksiService.getTransaksiById(id));
    }

    @GetMapping
    public Response getAllTransaksi() {
        return new Response("Berhasil melihat semua transaksi", HttpStatus.OK, transaksiService.getAllTransaksi());
    }

    @PutMapping("/{id}")
    public Response updateTransaksi(@PathVariable Integer id, @RequestBody TransaksiDTO transaksiDTO) {
        return new Response("Berhasil mengubah transaksi dengan id " + id, HttpStatus.OK, transaksiService.updateTransaksi(id, transaksiDTO));

    }

    @DeleteMapping("/{id}")
    public Response deleteTransaksi(@PathVariable Integer id) {
        if(transaksiService.deleteTransaksi(id)) {
            return new Response("Berhasil menghapus transaksi dengan id " + id, HttpStatus.OK);
        } else {
            return new Response("Transaksi dengan id " + id + " tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }
}
