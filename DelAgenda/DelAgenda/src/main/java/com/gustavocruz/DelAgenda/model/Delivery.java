package com.gustavocruz.DelAgenda.model;

import jakarta.persistence.*;

@Entity
@Table
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String clientName;

    @Column
    private String clientNumber;

    @Column
    private String Adress;

    @Column
    private Item Items;

    @Column
    private boolean Status;
}
