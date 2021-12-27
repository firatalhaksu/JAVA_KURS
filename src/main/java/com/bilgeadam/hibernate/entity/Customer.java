package com.bilgeadam.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Customers")
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "first_name")
    private String name;

    @Enumerated(EnumType.STRING)
    public CustomerTypes type;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Customer(){
        type = CustomerTypes.Regular;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerTypes getType() {
        return type;
    }

    public void setType(CustomerTypes type) {
        this.type = type;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}