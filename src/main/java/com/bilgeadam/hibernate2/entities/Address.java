package com.bilgeadam.hibernate2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "Country", nullable = false, length = 80)
    private String Country;
    @Column(name = "City", nullable = false, length = 80)
    private String City;
    @Column(name = "Street", nullable = false)
    private String Street;
    @Column(name = "Postal Code", nullable = false)
    private long PostalCode;
}
