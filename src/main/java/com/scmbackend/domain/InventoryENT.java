package com.scmbackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author fatemezahralotfi
 */
@Entity
@Table(name = "INVENTORY")
@Getter
@Setter
public class InventoryENT {

    @Id
    @GeneratedValue(generator = "InventorySequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "InventorySequence",allocationSize = 1,sequenceName = "INVENTORY_SEQ")
    @Column(name = "INVENTORY_ID")
    private Long id;

    //product
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "PRODUCER_ID",
         foreignKey = @ForeignKey(name = "PRODUCER_CODE"))
    private ProducerENT producerENTCode;

    //private String productName;
    //product code
    //producer name

    @Column(name = "AMOUNT_OF_PRODUCT_AVAILABLE")
    private Long amountOfProductAvailable;

    @Column(name = "PRODUCTION_START_DATE")
    private String productionStartDate;

    @Column(name = "PREPARATION_DATE")
    private String preparationDate;

    //supply
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPPLIER_ID",
            foreignKey = @ForeignKey(name = "SUPPLIER_CODE"))
    private SupplierENT supplierENTCode;

//    private Long rawMaterialCode;
//    private String rawMaterialName;
//    private String supplierName;

    @Column(name = "SUPPLY_START_DATE")
    private String supplyStartDate;

    @Column(name = "DELIVERY_DATE_OF_RAW_MATERIALS")
    private String deliveryDateOfRawMaterials;

    @Column(name = "AMOUNT_OF_RAW_MATERIAL_USED")
    private Long amountOfRawMaterialUsed;

    //distribute
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "DISTRIBUTOR_ID",
            foreignKey = @ForeignKey(name = "DISTRIBUTOR_CODE"))
    private DistributorENT distributorENTCode;

    //distributor name
    //amount of distributions

    @Column(name = "AMOUNT_OF_PRODUCT_SUPPLIED")
    private Long amountOfProductSupplied;

    @Column(name = "DISTRIBUTION_START_DATE")
    private String distributionStartDate;

    @Column(name = "DISTRIBUTION_END_DATE")
    private String distributionEndDate;

    @Builder
    protected InventoryENT(
            ProducerENT producerENTCode,
            Long amountOfProductAvailable,
            String productionStartDate,
            String preparationDate,
            SupplierENT supplierENTCode,
            String supplyStartDate,
            String deliveryDateOfRawMaterials,
            Long amountOfRawMaterialUsed,
            DistributorENT distributorENTCode,
            Long amountOfProductSupplied,
            String distributionStartDate,
            String distributionEndDate
    ){
        this.producerENTCode=producerENTCode;
        this.amountOfProductAvailable=amountOfProductAvailable;
        this.productionStartDate=productionStartDate;
        this.preparationDate=preparationDate;
        this.supplierENTCode=supplierENTCode;
        this.supplyStartDate=supplyStartDate;
        this.deliveryDateOfRawMaterials=deliveryDateOfRawMaterials;
        this.amountOfRawMaterialUsed=amountOfRawMaterialUsed;
        this.distributorENTCode=distributorENTCode;
        this.amountOfProductSupplied=amountOfProductSupplied;
        this.distributionStartDate=distributionStartDate;
        this.distributionEndDate=distributionEndDate;

        //add
    }

    public void edit(InventoryENT inventory){

        this.setProducerENTCode(inventory.getProducerENTCode());
        this.setAmountOfProductAvailable(inventory.getAmountOfProductAvailable());
        this.setProductionStartDate(inventory.getProductionStartDate());
        this.setPreparationDate(inventory.getPreparationDate());
        this.setSupplierENTCode(inventory.getSupplierENTCode());
        this.setSupplyStartDate(inventory.getSupplyStartDate());
        this.setDeliveryDateOfRawMaterials(inventory.getDeliveryDateOfRawMaterials());
        this.setAmountOfRawMaterialUsed(inventory.getAmountOfRawMaterialUsed());
        this.setDistributorENTCode(inventory.getDistributorENTCode());
        this.setAmountOfProductSupplied(inventory.getAmountOfProductSupplied());
        this.setDistributionStartDate(inventory.getDistributionStartDate());
        this.setDistributionEndDate(inventory.getDistributionEndDate());

    }

    public InventoryENT() {}
}
