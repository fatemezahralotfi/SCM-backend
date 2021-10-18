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
@Table(name = "PRODUCER")
@Getter
@Setter
public class ProducerENT {

    @Id
    @GeneratedValue(generator = "ProducerSequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ProducerSequence",allocationSize = 1,sequenceName = "PRODUCER_SEQ")
    @Column(name = "PRODUCER_ID")
    private Long id;

    @Column(name = "PRODUCER_NAME")
    private String producerName;

    @Column(name = "PRODUCT_CODE")
    private Long productCode;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "NUMBER_OF_AVAILABLE_PRODUCTS")
    private Long numberOfAvailableProducts;

    @OneToMany(mappedBy = "producerENTCode")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<InventoryENT> inventoryENT;

    @Builder
    protected ProducerENT(
            String producerName,
            Long productCode,
            String productName,
            String address,
            String phoneNumber,
            String nationalCode,
            String companyName,
            Long numberOfAvailableProducts
    ){
        this.producerName=producerName;
        this.productCode=productCode;
        this.productName=productName;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.nationalCode=nationalCode;
        this.companyName=companyName;
        this.numberOfAvailableProducts=numberOfAvailableProducts;

        //add
    }

    public void edit(ProducerENT producer){

        this.setProducerName(producer.getProducerName());
        this.setProductCode(producer.getProductCode());
        this.setProductName(producer.getProductName());
        this.setAddress(producer.getAddress());
        this.setPhoneNumber(producer.getPhoneNumber());
        this.setNationalCode(producer.getNationalCode());
        this.setCompanyName(producer.getCompanyName());
        this.setNumberOfAvailableProducts(producer.getNumberOfAvailableProducts());
    }

    public ProducerENT() {}
}
