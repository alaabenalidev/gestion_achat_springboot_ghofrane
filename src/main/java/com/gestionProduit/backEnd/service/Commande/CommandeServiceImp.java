package com.gestionProduit.backEnd.service.Commande;

import com.gestionProduit.backEnd.Entity.ClientProduit;
import com.gestionProduit.backEnd.Entity.Commande;
import com.gestionProduit.backEnd.Entity.LigneCommande;
import com.gestionProduit.backEnd.Entity.dtos.CommandeDto;
import com.gestionProduit.backEnd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CommandeServiceImp implements CommandeService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientProduitRepository clientProduitRepository;

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @Override
    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> getCommandeById(Integer id) {
        return commandeRepository.findById(id);
    }

    @Override
    public Commande createCommande(CommandeDto commandeDto) {
        Commande commande = new Commande();
        List<LigneCommande> ligneCommandes = new ArrayList<>();
        AtomicReference<Double> prixTotale = new AtomicReference<>((double) 0);
        commandeDto.items().forEach(item -> {
            LigneCommande ligneCommande = new LigneCommande();
            ClientProduit clientProduit = clientProduitRepository.findById(item.id()).get();
            ligneCommande.setClientProduit(clientProduit);
            ligneCommande.setQte(item.qte());

            prixTotale.updateAndGet(v -> (v + clientProduit.getPrix() * item.qte()));
            ligneCommande = ligneCommandeRepository.save(ligneCommande);
            ligneCommandes.add(ligneCommande);
        });
        commande.setLigneCommandes(ligneCommandes);
        commande.setPrixTotale(prixTotale.get());
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande, Integer id) {
        return null;
    }

    @Override
    public void removeCommandeById(Integer id) {
        commandeRepository.deleteById(id);
    }
}
