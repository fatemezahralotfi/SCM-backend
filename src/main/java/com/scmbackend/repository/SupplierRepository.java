package com.scmbackend.repository;

import com.scmbackend.domain.SupplierENT;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

/**
 * @author fatemezahralotfi
 */
public interface SupplierRepository extends JpaRepository<SupplierENT, Id> {

    List<SupplierENT> findAll();

    Optional<SupplierENT> findById(Long id);

    void deleteById(Long id);
}
