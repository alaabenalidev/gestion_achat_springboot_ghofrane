package com.gestionProduit.backEnd.repository;

import com.gestionProduit.backEnd.Entity.ClientProduit;
import com.gestionProduit.backEnd.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientProduitRepository extends JpaRepository<ClientProduit, Integer> {

    List<ClientProduit> findByProduit(Produit produit);

    void deleteByProduit(Produit produit);
}
