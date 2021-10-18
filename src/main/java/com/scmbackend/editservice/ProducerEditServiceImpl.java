//package com.scm.scmbackend.editservice;
//
//
//import com.scm.scmbackend.domain.ProducerENT;
//import com.scm.scmbackend.repository.ProducerRepository;
//import javassist.NotFoundException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//import com.scmbackend.editservice.ProducerEditService;
//
//import javax.persistence.Id;
//import java.util.Optional;
//
///**
// * @author fatemezahralotfi
// */
//@Service
//public class ProducerEditServiceImpl implements ProducerEditService {
//
//    private final ProducerRepository producerRepository;
//
//    /**
//     * @param producerRepository producer repository
//     */
//    public ProducerEditServiceImpl(ProducerRepository producerRepository) {
//        this.producerRepository = producerRepository;
//    }
//
//    /**
//     * @param id id
//     * @param producer producer entity
//     * @throws NotFoundException NotFoundException
//     */
//    @Override
//    public void edit(Id id, ProducerENT producer) throws NotFoundException {
//
//        if(producer==null){
//            throw new EmptyResultDataAccessException("please fill it",1);
//        }
//
//        if(id==null){
//            throw new EmptyResultDataAccessException("don't have code",1);
//        }
//
//        Optional<ProducerENT> existingProducer= Optional.of(producerRepository.getOne(id));
//
//        ProducerENT ProducerDB = existingProducer
//                .orElseThrow(()-> new NotFoundException("can't fount this item"));
//
//        ProducerDB.edit(producer);
//
//        producerRepository.add(producer);
//    }
//}
