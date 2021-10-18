//package com.scm.scmbackend.editservice;
//
//import com.scmbackend.domain.SupplierENT;
//import com.scmbackend.repository.SupplierRepository;
//import javassist.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//import com.scmbackend.editservice.SupplierEditService;
//
//import javax.persistence.Id;
//import java.util.Optional;
//
///**
// * @author fatemezahralotfi
// */
//@Service
//public class SupplierEditServiceImpl implements SupplierEditService {
//
//    @Autowired
//    private final SupplierRepository supplierRepository;
//
//    /**
//     * @param supplierRepository supplier repository
//     */
//    public SupplierEditServiceImpl(SupplierRepository supplierRepository) {
//        this.supplierRepository = supplierRepository;
//    }
//
//    /**
//     * @param id id
//     * @param supplier supplier entity
//     * @throws NotFoundException NotFoundException
//     */
//    @Override
//    public void edit(Id id, SupplierENT supplier) throws NotFoundException {
//
//        if(supplier==null){
//            throw new EmptyResultDataAccessException("please fill it",1);
//        }
//
//        if(id==null){
//            throw new EmptyResultDataAccessException("don't have code",1);
//        }
//
//        Optional<SupplierENT> existingSupplier= Optional.of(supplierRepository.getOne(id));
//
//        SupplierENT supplierDB = existingSupplier
//                .orElseThrow(()-> new NotFoundException("can't fount this item"));
//
//        supplierDB.edit(supplier);
//
//        supplierRepository.add(supplier);
//    }
//}
