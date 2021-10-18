package com.scmbackend.controller;


import com.scmbackend.domain.SupplierENT;
import com.scmbackend.repository.SupplierRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/scm")
@Transactional
public class SupplierController {

    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/suppliers")
    public List<SupplierENT> getAllProducers() {
        return supplierRepository.findAll();
    }

    @GetMapping("/suppliers/{id}")
    public SupplierENT getProducers(@PathVariable Long id) {
        return supplierRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/suppliers")
    public ResponseEntity createProducers(@RequestBody SupplierENT supplierENT) throws URISyntaxException {
        SupplierENT savedSuppliers = supplierRepository.save(supplierENT);
        return ResponseEntity.created(new URI("/suppliers/" + savedSuppliers.getId())).body(savedSuppliers);
    }

    @PutMapping("/suppliers/{id}")
    public ResponseEntity updateProducers(@PathVariable Long id, @RequestBody SupplierENT supplierENT) {
        SupplierENT currentSuppliers = supplierRepository.findById(id).orElseThrow(RuntimeException::new);
        currentSuppliers = supplierRepository.save(supplierENT);
        return ResponseEntity.ok(currentSuppliers);
    }

    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity deleteProducers(@PathVariable Long id) {
        supplierRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
