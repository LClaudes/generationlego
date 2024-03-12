package com.example.generationlego.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="ordini")
public class Ordini {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Date data;
    @Column
    private Double importo;
    @Column
}
