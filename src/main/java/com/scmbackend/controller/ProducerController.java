package com.scmbackend.controller;

import com.scmbackend.domain.ProducerENT;
import com.scmbackend.repository.ProducerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/scm")
@Transactional
public class ProducerController {

    private final ProducerRepository producerRepository;

    public ProducerController(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @GetMapping("/producer")
    public List<ProducerENT> getAllProducers() {
        return producerRepository.findAll();
    }

    @GetMapping("/producer/{id}")
    public ProducerENT getProducers(@PathVariable Long id) {
        return producerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/producer")
    public ResponseEntity createProducers(@RequestBody ProducerENT producerENT) throws URISyntaxException {
        ProducerENT savedProducers = producerRepository.save(producerENT);
        return ResponseEntity.created(new URI("/producer/" + savedProducers.getId())).body(savedProducers);
    }

    @PutMapping("/producer/{id}")
    public ResponseEntity updateProducers(@PathVariable Long id, @RequestBody ProducerENT producerENT) {
        ProducerENT currentProducers = producerRepository.findById(id).orElseThrow(RuntimeException::new);
        currentProducers = producerRepository.save(producerENT);
        return ResponseEntity.ok(currentProducers);
    }

    @DeleteMapping("/producer/{id}")
    public ResponseEntity deleteProducers(@PathVariable Long id) {
        producerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
