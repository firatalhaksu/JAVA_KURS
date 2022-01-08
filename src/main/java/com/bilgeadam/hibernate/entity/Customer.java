package com.bilgeadam.hibernate.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "first_name", length = 80, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CustomerTypes type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ElementCollection
    private List<String> emails;

    public Customer(){
        type = CustomerTypes.Regular;
    }

    public int getID() {
        return ID;
    }

    public void setID(int uuid) {
        this.ID = uuid;
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

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getEmails(){
        return emails;
    }

    public void setEmails(List<String>  emails){
        this.emails = emails;
    }

    public void addEmail(String email){
        if (emails == null){
            emails = new ArrayList<>();
        }
        emails.add(email);
    }
}