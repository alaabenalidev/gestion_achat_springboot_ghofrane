package com.gestionProduit.backEnd.repository;

import com.gestionProduit.backEnd.Entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {
}
