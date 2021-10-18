//package com.scmbackend.addservice;
//
//import com.scmbackend.domain.InventoryENT;
//import com.scmbackend.repository.InventoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
///**
// * @author fatemezahralotfi
// */
//@Service
//@Transactional
//public class InventoryAddServiceImpl implements InventoryAddService{
//
//    @Autowired
//    public final InventoryRepository inventoryRepository;
//
//    /**
//     * @param inventoryRepository inventory repository
//     */
//    public InventoryAddServiceImpl(InventoryRepository inventoryRepository) {
//        this.inventoryRepository = inventoryRepository;
//    }
//
//    /**
//     * @param inventory inventory entity
//     */
//    @Override
//    public void add(InventoryENT inventory) {
//
//        if(inventory==null){
//            throw new EmptyResultDataAccessException("please fill it",1);
//        }
//
//        inventoryRepository.add(inventory);
//    }
//}
