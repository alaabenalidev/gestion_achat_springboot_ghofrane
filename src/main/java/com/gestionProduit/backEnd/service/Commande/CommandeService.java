package com.gestionProduit.backEnd.service.Commande;

import com.gestionProduit.backEnd.Entity.Categorie;
import com.gestionProduit.backEnd.Entity.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {
    List<Commande> getAllCommande();
    Optional<Commande> getCommandeById(Integer id);
    Commande createCommande(Commande commande);
    Commande updateCommande(Commande commande,Integer id);
    void removeCommandeById(Integer id);
}
