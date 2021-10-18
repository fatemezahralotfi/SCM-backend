package com.scmbackend.repository;

import com.scmbackend.domain.ProducerENT;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

/**
 * @author fatemezahralotfi
 */
public interface ProducerRepository extends JpaRepository<ProducerENT, Id> {

    List<ProducerENT> findAll();

    Optional<ProducerENT> findById(Long id);

    void deleteById(Long id);
}
