//package com.scmbackend.editservice;
//
//import com.scmbackend.domain.DistributorENT;
//import com.scmbackend.repository.DistributorRepository;
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
//public class DistributorEditServiceImpl implements DistributorEditService{
//
//    private final DistributorRepository distributorRepository;
//
//    /**
//     * @param distributorRepository distributor repository
//     */
//    public DistributorEditServiceImpl(DistributorRepository distributorRepository) {
//        this.distributorRepository = distributorRepository;
//    }
//
//    /**
//     * @param id id
//     * @param distributor distributor entity
//     * @throws NotFoundException NotFoundException
//     */
//    @Override
//    public void edit(Id id, DistributorENT distributor) throws NotFoundException {
//
//        if(distributor==null){
//            throw new EmptyResultDataAccessException("please fill it",1);
//        }
//
//        if(id==null){
//            throw new EmptyResultDataAccessException("don't have code",1);
//        }
//
//        Optional<DistributorENT> existingDistributor= Optional.of(distributorRepository.getOne(id));
//
//        DistributorENT distributorDB = existingDistributor
//                .orElseThrow(()-> new NotFoundException("can't fount this item"));
//
//        distributorDB.edit(distributor);
//
//        distributorRepository.add(distributor);
//    }
//}
