package com.bilgeadam.hibernate;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import java.util.UUID;

@DynamicUpdate
@DynamicInsert
@Table(appliesTo = "customers")

public class Customer {

    private UUID ID;
    private String firstName;
    private String lastName;
    private long phoneNumber;


}