package com.gestionProduit.backEnd.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Produit;
    @Column(nullable = false, unique = true)
    private String type;
    @Column(nullable = false, unique = true)
    private String reference;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    private Categorie categorie;
}
