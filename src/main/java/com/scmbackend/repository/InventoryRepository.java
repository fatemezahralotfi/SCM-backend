package com.scmbackend.repository;

import com.scmbackend.domain.InventoryENT;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

/**
 * @author fatemezahralotfi
 */
public interface InventoryRepository extends JpaRepository<InventoryENT, Id> {

    List<InventoryENT> findAll();

    Optional<InventoryENT> findById(Long id);

    void deleteById(Long id);
}
