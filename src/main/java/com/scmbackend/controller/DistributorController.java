package com.scmbackend.controller;

import com.scmbackend.domain.DistributorENT;
import com.scmbackend.repository.DistributorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/scm")
@Transactional
public class DistributorController {

    private final DistributorRepository distributorRepository;

    public DistributorController(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    @GetMapping("/distributor")
    public List<DistributorENT> getAllDistributors() {
        return distributorRepository.findAll();
    }

    @GetMapping("/distributor/{id}")
    public DistributorENT getDistributor(@PathVariable Long id) {
        return distributorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/distributor")
    public ResponseEntity createDistributor(@RequestBody DistributorENT distributorENT) throws URISyntaxException {
        DistributorENT savedDistributor = distributorRepository.save(distributorENT);
        return ResponseEntity.created(new URI("/distributor/" + savedDistributor.getId())).body(savedDistributor);
    }

    @PutMapping("/distributor/{id}")
    public ResponseEntity updateDistributor(@PathVariable Long id, @RequestBody DistributorENT distributorENT) {
        DistributorENT currentDistributor = distributorRepository.findById(id).orElseThrow(RuntimeException::new);
        currentDistributor = distributorRepository.save(distributorENT);
        return ResponseEntity.ok(currentDistributor);
    }

    @DeleteMapping("/distributor/{id}")
    public ResponseEntity deleteDistributor(@PathVariable Long id) {
        distributorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
