package com.scmbackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

/**
 * @author fatemezahralotfi
 */
@Entity
@Getter
@Setter
@Table(name = "DISTRIBUTOR")
public class DistributorENT {

    @Id
    @GeneratedValue(generator = "DistributorSequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DistributorSequence",allocationSize = 1,sequenceName = "DISTRIBUTOR_SEQ")
    @Column(name = "DISTRIBUTOR_ID")
    private Long id;

    @Column(name = "DISTRIBUTOR_NAME")
    private String distributorName;

    @Column(name = "DISTRIBUTED_PRODUCT_CODE")
    private Long distributedProductCode;

    @Column(name = "DISTRIBUTED_PRODUCT_NAME")
    private String distributedProductName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "AMOUNT_OF_DISTRIBUTIONS")
    private Long amountOfDistributions;

    @OneToMany(mappedBy = "distributorENTCode")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<InventoryENT> inventoryENT;

    @Builder
    protected DistributorENT(
            String distributorName,
            Long   distributedProductCode,
            String distributedProductName,
            String address,
            String phoneNumber,
            String nationalCode,
            String companyName,
            Long   amountOfDistributions
    ){
        this.distributorName=distributorName;
        this.distributedProductCode=distributedProductCode;
        this.distributedProductName=distributedProductName;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.nationalCode=nationalCode;
        this.companyName=companyName;
        this.amountOfDistributions=amountOfDistributions;

        //add
    }

    public void edit(DistributorENT distributor){

        this.setDistributorName(distributor.getDistributorName());
        this.setDistributedProductCode(distributor.getDistributedProductCode());
        this.setDistributedProductName(distributor.getDistributedProductName());
        this.setAddress(distributor.getAddress());
        this.setPhoneNumber(distributor.getPhoneNumber());
        this.setNationalCode(distributor.getNationalCode());
        this.setCompanyName(distributor.getCompanyName());
        this.setAmountOfDistributions(distributor.getAmountOfDistributions());

    }

    public DistributorENT() {}
}
