package com.bilgeadam.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String Country;

    @Column
    private String City;

    @Column
    private String Street;

    @Column
    private long PostalCode;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    public String getCountry() {
        return Country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public long getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(long postalCode) {
        PostalCode = postalCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
