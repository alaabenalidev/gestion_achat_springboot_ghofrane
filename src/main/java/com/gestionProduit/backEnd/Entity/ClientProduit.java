package com.gestionProduit.backEnd.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "client_produit")
public class ClientProduit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    client fournisseur;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    Produit produit;

    float prix;

    int remis;


}
