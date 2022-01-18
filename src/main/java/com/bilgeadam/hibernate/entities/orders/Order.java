package com.bilgeadam.hibernate.entities.orders;

import com.bilgeadam.hibernate.entities.customers.Customer;
import com.bilgeadam.hibernate.entities.toys.Toy;
import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "ID", name = "customer_id")
    private Customer customer;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable (name = "order_details",joinColumns = @JoinColumn(referencedColumnName = "ID", name = "order_id"))
    @MapKeyJoinColumn(referencedColumnName = "ID", name = "toy_id")
    @Column(name = "count")
    Map<Toy, Long> orderDetails;


    public Order(Customer customer, Map<Toy, Long> orderDetails) {
        this.customer = customer;
        this.orderDetails = orderDetails;
    }
}
