package com.gestionProduit.backEnd.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "client_produit")
public class ClientProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "fournisseur_id")
    client fournisseur;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "produit_id")
    Produit produit;

    float prix;

    int quantite;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<LigneCommande> ligneCommandes;

}
