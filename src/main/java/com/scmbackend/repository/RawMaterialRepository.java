package com.scmbackend.repository;

import com.scmbackend.domain.RawMaterialENT;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

/**
 * @author fatemezahralotfi
 */
public interface RawMaterialRepository extends JpaRepository<RawMaterialENT, Id> {

    List<RawMaterialENT> findAll();

    Optional<RawMaterialENT> findById(Long id);

    void deleteById(Long id);
}
