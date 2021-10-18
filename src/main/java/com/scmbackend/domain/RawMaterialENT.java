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
@Table(name = "RAW_MATERIAL")
public class RawMaterialENT {

    @Id
    @GeneratedValue(generator = "RawMaterialSequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "RawMaterialSequence",allocationSize = 1,sequenceName = "RAW_MATERIAL_SEQ")
    @Column(name = "RAW_MATERIAL_ID")
    private Long id;

    @Column(name = "RAW_MATERIAL_NAME")
    private String rawMaterialName;

    @Column(name = "RAW_MATERIAL_UNIT")
    private Unit rawMaterialUnit;
}
