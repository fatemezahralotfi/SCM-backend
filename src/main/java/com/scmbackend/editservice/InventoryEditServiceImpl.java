//package com.scmbackend.editservice;
//
//import com.scmbackend.domain.InventoryENT;
//import com.scmbackend.repository.InventoryRepository;
//import javassist.NotFoundException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.Id;
//import java.util.Optional;
//
///**
// * @author fatemezahralotfi
// */
//@Service
//public class InventoryEditServiceImpl implements  InventoryEditService{
//
//    private final InventoryRepository inventoryRepository;
//
//    /**
//     * @param inventoryRepository inventory repository
//     */
//    public InventoryEditServiceImpl(InventoryRepository inventoryRepository) {
//        this.inventoryRepository = inventoryRepository;
//    }
//
//    /**
//     * @param id id
//     * @param inventory inventory entity
//     * @throws NotFoundException NotFoundException
//     */
//    @Override
//    public void edit(Id id, InventoryENT inventory) throws NotFoundException {
//
//        if(inventory==null){
//            throw new EmptyResultDataAccessException("please fill it",1);
//        }
//
//        if(id==null){
//            throw new EmptyResultDataAccessException("don't have code",1);
//        }
//
//        Optional<InventoryENT> existingInventory= Optional.of(inventoryRepository.getOne(id));
//
//        InventoryENT InventoryDB = existingInventory
//                .orElseThrow(()-> new NotFoundException("can't fount this item"));
//
//        InventoryDB.edit(inventory);
//
//        inventoryRepository.add(inventory);
//    }
//}
