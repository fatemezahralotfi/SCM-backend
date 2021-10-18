package com.scmbackend.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author fatemezahralotfi
 */
@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class ProductENT {

    @Id
    @GeneratedValue(generator = "ProductSequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ProductSequence",allocationSize = 1,sequenceName = "PRODUCT_SEQ")
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_UNIT")
    private Unit productUnit;
}
