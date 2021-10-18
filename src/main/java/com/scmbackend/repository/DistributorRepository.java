package com.scmbackend.repository;

import com.scmbackend.domain.DistributorENT;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

/**
 * @author fatemezahralotfi
 */
public interface DistributorRepository extends JpaRepository<DistributorENT, Id> {

    List<DistributorENT> findAll();

    Optional<DistributorENT> findById(Long id);

    void deleteById(Long id);
}
