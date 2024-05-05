package com.gestionProduit.backEnd.repository;

import com.gestionProduit.backEnd.Entity.Categorie;
import com.gestionProduit.backEnd.Entity.Produit;
import com.gestionProduit.backEnd.Entity.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<client,Integer> {

    List<client> findByCategorie(Categorie categorie);

}
