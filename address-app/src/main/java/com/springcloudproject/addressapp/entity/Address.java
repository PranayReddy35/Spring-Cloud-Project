package com.springcloudproject.addressapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="lane1")
    private String lane1;
    @Column(name="lane2")
    private String lane2;
    @Column(name="zip")
    private String zip;
    @Column(name="state")
    private String state;
}
