package com.gestionProduit.backEnd.repository;

import com.gestionProduit.backEnd.Entity.ClientProduit;
import com.gestionProduit.backEnd.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientProduitRepository extends JpaRepository<ClientProduit, Integer> {

    List<ClientProduit> findByProduit(Produit produit);

    @Transactional
    @Modifying
    @Query("delete from ClientProduit c where c.produit = ?1")
    void deleteByProduit(Produit produit);
}
