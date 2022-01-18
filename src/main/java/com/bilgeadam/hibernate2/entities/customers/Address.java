package com.bilgeadam.hibernate2.entities.customers;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "country", nullable = false, length = 80)
    private String Country;
    @Column(name = "city", nullable = false, length = 80)
    private String City;
    @Column(name = "street", nullable = false)
    private String Street;
    @Column(name = "postal_code", nullable = false)
    private long PostalCode;
}
