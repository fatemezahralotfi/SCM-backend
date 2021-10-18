package com.scmbackend.controller;

import com.scmbackend.domain.InventoryENT;
import com.scmbackend.repository.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/scm")
@Transactional
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping("/inventory")
    public List<InventoryENT> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @GetMapping("/inventory/{id}")
    public InventoryENT getInventory(@PathVariable Long id) {
        return inventoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/inventory")
    public ResponseEntity createInventory(@RequestBody InventoryENT inventoryENT) throws URISyntaxException {
        System.out.println("its controller");
        InventoryENT savedInventory = inventoryRepository.save(inventoryENT);
        System.out.println("its controller"+savedInventory);
        return ResponseEntity.created(new URI("/inventory/" + savedInventory.getId())).body(savedInventory);
    }

    @PutMapping("/inventory/{id}")
    public ResponseEntity updateInventory(@PathVariable Long id, @RequestBody InventoryENT inventoryENT) {
        InventoryENT currentInventory = inventoryRepository.findById(id).orElseThrow(RuntimeException::new);
        currentInventory = inventoryRepository.save(inventoryENT);
        return ResponseEntity.ok(currentInventory);
    }

    @DeleteMapping("/inventory/{id}")
    public ResponseEntity deleteInventory(@PathVariable Long id) {
        inventoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
