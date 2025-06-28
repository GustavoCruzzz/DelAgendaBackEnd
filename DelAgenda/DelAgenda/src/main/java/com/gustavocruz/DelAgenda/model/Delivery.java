package com.gustavocruz.DelAgenda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String client_name;

    @Column
    private Long client_number;

    @Column
    private String address;

    @Column
    private String status;

    @Column
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    private List<Item> items;



}
