package com.bilgeadam.hibernate.entities.customers;

import com.bilgeadam.hibernate.entities.orders.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 150)
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private Address address;

    @OneToMany(mappedBy = "customer")
    private Set<Order> order;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_state", length = 50)
    //@ColumnDefault(value = "'ACTIVE'")
    private State accountState;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountState = State.ACTIVE;
    }

    public Customer(){
        this.accountState = State.ACTIVE;
    }
}

