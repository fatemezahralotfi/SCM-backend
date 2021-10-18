package com.scmbackend.repository;

import com.scmbackend.domain.ProductENT;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

/**
 * @author fatemezahralotfi
 */
public interface ProductRepository extends JpaRepository<ProductENT, Id> {

    List<ProductENT> findAll();

    Optional<ProductENT> findById(Long id);

    void deleteById(Long id);
}
