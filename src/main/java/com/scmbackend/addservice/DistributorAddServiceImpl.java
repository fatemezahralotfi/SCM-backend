//package com.scmbackend.addservice;
//
//import com.scmbackend.domain.DistributorENT;
//import com.scmbackend.repository.DistributorRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author fatemezahralotfi
// */
//@Service
//public class DistributorAddServiceImpl{
//
////        @Autowired
//        private DistributorRepository distributorRepository;
//
//        public List<DistributorENT> getAllDistributors(){
//
////            logger.error("error happened");
////            logger.trace(" Error !!!");
//            List<DistributorENT> doctor= new ArrayList<DistributorENT>();
//            distributorRepository.findAll().forEach(doctor::add);
//            return doctor;
//
//        }
//
////    @Autowired
////    public final DistributorRepository distributorRepository;
////
////    /**
////     * @param distributorRepository distributor repository
////     */
////    public DistributorAddServiceImpl(DistributorRepository distributorRepository) {
////        this.distributorRepository = distributorRepository;
////    }
////
////
////    /**
////     * @param distributor distributor entity
////     */
////    @Override
////    public void add(DistributorENT distributor) {
////
////        if(distributor==null){
////            throw new EmptyResultDataAccessException("please fill it",1);
////        }
////
////        distributorRepository.add(distributor);
////    }
//}
