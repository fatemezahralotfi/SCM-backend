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
@Table(name = "SUPPLIER")
@Getter
@Setter
public class SupplierENT {

    @Id
    @GeneratedValue(generator = "SupplierSequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SupplierSequence",allocationSize = 1,sequenceName = "SUPPLIER_SEQ")
    @Column(name = "SUPPLIER_ID")
    private Long id;

    @Column(name = "SUPPLIER_NAME")
    private String supplierName;

    @Column(name = "SUPPLY_RAW_MATERIAL_CODE")
    private Long supplyRawMaterialCode;

    @Column(name = "SUPPLY_RAW_MATERIAL_NAME")
    private String supplyRawMaterialName;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "AMOUNT_OF_AVAILABLE_SUPPLY_RAW_MATERIAL")
    private Long amountOfAvailableSupplyRawMaterial;

    @OneToMany(mappedBy = "supplierENTCode")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<InventoryENT> inventoryENT;

    @Builder
    protected SupplierENT(
            String supplierName,
            Long supplyRawMaterialCode,
            String supplyRawMaterialName,
            String unit,
            String address,
            String phoneNumber,
            String nationalCode,
            String companyName,
            Long amountOfAvailableSupplyRawMaterial
    ){
        this.supplierName=supplierName;
        this.supplyRawMaterialCode=supplyRawMaterialCode;
        this.supplyRawMaterialName=supplyRawMaterialName;
        this. unit=unit;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.nationalCode=nationalCode;
        this.companyName=companyName;
        this.amountOfAvailableSupplyRawMaterial=amountOfAvailableSupplyRawMaterial;

        //add
    }

    public void edit(SupplierENT supplier){

        this.setSupplierName(supplier.getSupplierName());
        this.setSupplyRawMaterialCode(supplier.getSupplyRawMaterialCode());
        this.setSupplyRawMaterialName(supplier.getSupplyRawMaterialName());
        this.setUnit(supplier.getUnit());
        this.setAddress(supplier.getAddress());
        this.setPhoneNumber(supplier.getPhoneNumber());
        this.setNationalCode(supplier.getNationalCode());
        this.setCompanyName(supplier.getCompanyName());
        this.setAmountOfAvailableSupplyRawMaterial(supplier.getAmountOfAvailableSupplyRawMaterial());

    }

    public SupplierENT() {}
}
