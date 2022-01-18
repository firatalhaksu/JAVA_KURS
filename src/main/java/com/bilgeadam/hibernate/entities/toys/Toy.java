package com.bilgeadam.hibernate.entities.toys;

import jakarta.persistence.*;
import lombok.*;

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
    private Long ID;

    @Column (name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column (name = "type")
    private ToyType type;

    public Toy(String name, ToyType type) {
        this.name = name;
        this.type = type;
    }
}
