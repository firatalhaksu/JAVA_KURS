package com.bilgeadam.hibernate2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "toys", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "type"}))
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //"strategy" yerine "generator" ile kendi Generation metodumuzu çağırabiliyoruz*****
    @Column(name = "ID")
    private Long ID;

    @Column (name = "Name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column (name = "Type")
    private ToyType type;

    @ManyToMany(mappedBy = "toys")
    private Set<Customer> customers;

    public Toy(String name, ToyType type) {
        this.name = name;
        this.type = type;
    }
}
