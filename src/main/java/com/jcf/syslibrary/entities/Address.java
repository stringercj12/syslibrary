package com.jcf.syslibrary.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "tb_address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "address_id")
    private UUID addressId;

    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private boolean isPrincipal;
}
