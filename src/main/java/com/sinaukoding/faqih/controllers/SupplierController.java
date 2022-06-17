package com.sinaukoding.faqih.controllers;

import com.sinaukoding.faqih.entities.dto.SupplierDTO;
import com.sinaukoding.faqih.services.SupplierService;
import com.sinaukoding.faqih.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping
    public Response createSupplier(@RequestBody SupplierDTO supplierDTO) {
        return new Response("Barang berhasil ditambahkan", HttpStatus.CREATED, supplierService.createSupplier(supplierDTO));
    }

    @GetMapping
    public Response getAllBarang() {
        List<SupplierDTO> data = supplierService.getAllSupplier();
        return new Response(data != null ? "Berhasil mengambil semua barang" : "Data tidak ada", HttpStatus.OK, data);
    }

    @GetMapping("/find-name/")
    public Response getSupplierByName(@RequestParam String name) {
        List<SupplierDTO> data = supplierService.getSupplierByName(name);
        return new Response(data != null ? "Berhasil mengambil barang berdasarkan nama" : "Data tidak ada", HttpStatus.OK, data);
    }


    @PutMapping("/{id}")
    public Response updateSupplier(@PathVariable Integer id, @RequestBody SupplierDTO supplierDTO) {
        return new Response("Berhasil mengubah barang dengan id " + id, HttpStatus.OK, supplierService.updateSupplier(id, supplierDTO));
    }

    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id) {
        if(supplierService.deleteSupplier(id)) {
            return new Response("Berhasil menghapus barang dengan id " + id, HttpStatus.OK);
        } else {
            return new Response("Barang dengan id " + id + " tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }
}
