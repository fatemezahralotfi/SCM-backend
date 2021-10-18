package com.scmbackend.controller;

import com.scmbackend.domain.RawMaterialENT;
import com.scmbackend.repository.RawMaterialRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/scm")
@Transactional
public class RawMaterialController {

    private final RawMaterialRepository rawMaterialRepository;

    public RawMaterialController(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @GetMapping("/rawMaterial")
    public List<RawMaterialENT> getAllRawMaterials() {
        return rawMaterialRepository.findAll();
    }

    @GetMapping("/rawMaterial/{id}")
    public RawMaterialENT getRawMaterial(@PathVariable Long id) {
        return rawMaterialRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/rawMaterial")
    public ResponseEntity createRawMaterial(@RequestBody RawMaterialENT rawMaterialENT) throws URISyntaxException {
        RawMaterialENT savedRawMaterial = rawMaterialRepository.save(rawMaterialENT);
        return ResponseEntity.created(new URI("/rawMaterial/" + savedRawMaterial.getId())).body(savedRawMaterial);
    }

    @PutMapping("/rawMaterial/{id}")
    public ResponseEntity updateRawMaterial(@PathVariable Long id, @RequestBody RawMaterialENT rawMaterialENT) {
        RawMaterialENT currentRawMaterial = rawMaterialRepository.findById(id).orElseThrow(RuntimeException::new);
        currentRawMaterial = rawMaterialRepository.save(rawMaterialENT);
        return ResponseEntity.ok(currentRawMaterial);
    }

    @DeleteMapping("/rawMaterial/{id}")
    public ResponseEntity deleteRawMaterial(@PathVariable Long id) {
        rawMaterialRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
