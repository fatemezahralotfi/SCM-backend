//package com.scmbackend.addservice;
//
//import com.scmbackend.domain.ProducerENT;
//import com.scmbackend.repository.ProducerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//public class ProducerAddServiceImpl implements ProducerAddService{
//
//    @Autowired
//    public final ProducerRepository producerRepository;
//
//    /**
//     * @param producerRepository producer repository
//     */
//    public ProducerAddServiceImpl(ProducerRepository producerRepository) {
//        this.producerRepository = producerRepository;
//    }
//
//    /**
//     * @param producer producer entity
//     */
//    @Override
//    public void add(ProducerENT producer) {
//
//        if(producer==null){
//            throw new EmptyResultDataAccessException("please fill it",1);
//        }
//
//        producerRepository.add(producer);
//    }
//}
