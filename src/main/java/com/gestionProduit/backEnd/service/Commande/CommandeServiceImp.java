package com.gestionProduit.backEnd.service.Commande;

import com.gestionProduit.backEnd.Entity.Categorie;
import com.gestionProduit.backEnd.Entity.Commande;
import com.gestionProduit.backEnd.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImp implements CommandeService {


    @Override
    public List<Commande> getAllCommande() {
        return List.of();
    }

    @Override
    public Optional<Commande> getCommandeById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Commande createCommande(Commande commande) {
        return null;
    }

    @Override
    public Commande updateCommande(Commande commande, Integer id) {
        return null;
    }

    @Override
    public void removeCommandeById(Integer id) {

    }
}
