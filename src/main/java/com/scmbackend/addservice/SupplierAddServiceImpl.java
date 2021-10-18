//package com.scmbackend.addservice;
//
//import com.scmbackend.domain.SupplierENT;
//import com.scmbackend.repository.SupplierRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//public class SupplierAddServiceImpl implements SupplierAddService{
//
//    @Autowired
//    public final SupplierRepository supplierRepository;
//
//    /**
//     * @param supplierRepository supplier repository
//     */
//    public SupplierAddServiceImpl(SupplierRepository supplierRepository) {
//        this.supplierRepository = supplierRepository;
//    }
//
//    /**
//     * @param supplier supplier entity
//     */
//    @Override
//    public void add(SupplierENT supplier) {
//
//        if(supplier==null){
//            throw new EmptyResultDataAccessException("please fill it",1);
//        }
//
//        supplierRepository.add(supplier);
//    }
//}
