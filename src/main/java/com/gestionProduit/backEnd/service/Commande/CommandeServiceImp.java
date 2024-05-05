package com.gestionProduit.backEnd.service.Commande;

import com.gestionProduit.backEnd.Entity.Categorie;
import com.gestionProduit.backEnd.Entity.Commande;
import com.gestionProduit.backEnd.Entity.LigneCommande;
import com.gestionProduit.backEnd.Entity.dtos.CommandeDto;
import com.gestionProduit.backEnd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        commande.setClient(clientRepository.findById(commandeDto.client()).get());
        commandeDto.items().forEach(item -> {
            LigneCommande ligneCommande  = new LigneCommande();
            ligneCommande.setProduit(clientProduitRepository.findById(item.id()).get());
            ligneCommande.setQte(item.qte());
            ligneCommande = ligneCommandeRepository.save(ligneCommande);
            ligneCommandes.add(ligneCommande);
        });
        commande.setLigneCommandes(ligneCommandes);
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
