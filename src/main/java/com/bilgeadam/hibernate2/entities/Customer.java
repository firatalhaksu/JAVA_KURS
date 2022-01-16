package com.bilgeadam.hibernate2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long ID;

    @Column(name = "Name", nullable = false, length = 150)
    private String firstName;

    @Column(name = "Surname", nullable = false, length = 150)
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {@JoinColumn(referencedColumnName = "ID", name = "Customer_ID")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "ID", name = "Toy_ID")}
    )
    private Set<Toy> toys;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addToy (Toy toy){
        if (getToys() == null){
            setToys(new HashSet<>());
        }

        getToys().add(toy);
    }
}
