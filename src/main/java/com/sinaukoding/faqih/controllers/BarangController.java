package com.sinaukoding.faqih.controllers;

import com.sinaukoding.faqih.entities.dto.BarangDTO;
import com.sinaukoding.faqih.services.BarangService;
import com.sinaukoding.faqih.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    BarangService barangService;

    @PostMapping
    public Response createBarang(@RequestBody BarangDTO barangDTO) {
        return new Response("Barang berhasil ditambahkan", HttpStatus.CREATED, barangService.createBarang(barangDTO));
    }

    @GetMapping
    public Response getAllBarang() {
        return new Response("Berhasil mengambil semua barang", HttpStatus.OK, barangService.getAllBarang());
    }

    @GetMapping("/find-name/")
    public Response getBarangByName(@RequestParam String name) {
        List<BarangDTO> data = barangService.getBarangByName(name);
        return new Response(data != null ? "Berhasil mengambil barang berdasarkan nama" : "Data tidak ada", HttpStatus.OK, data);
    }

    @GetMapping("/{id}")
    public Response getBarangById(@PathVariable Integer id) {
        return new Response("Berhasil mengambil barang dengan id " + id, HttpStatus.OK, barangService.getBarangById(id));
    }

    @PutMapping("/{id}")
    public Response updateBarang(@PathVariable Integer id, @RequestBody BarangDTO barangDTO) {
        return new Response("Berhasil mengubah barang dengan id " + id, HttpStatus.OK, barangService.updateBarang(id, barangDTO));
    }

    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id) {
        if(barangService.deleteBarang(id)) {
            return new Response("Berhasil menghapus barang dengan id " + id, HttpStatus.OK);
        } else {
            return new Response("Barang dengan id " + id + " tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }
}
