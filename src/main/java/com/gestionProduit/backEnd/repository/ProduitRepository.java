package com.gestionProduit.backEnd.repository;

import com.gestionProduit.backEnd.Entity.Categorie;
import com.gestionProduit.backEnd.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Integer> {

    List<Produit> findByCategorie(Categorie categorie);

    @Query("""
            select p from Produit p
            where upper(p.type) like upper(concat('%', ?1, '%')) and upper(p.reference) like upper(concat('%', ?2, '%')) and upper(p.description) like upper(concat('%', ?3, '%'))""")
    List<Produit> rechercheProduit(String nom);
}
