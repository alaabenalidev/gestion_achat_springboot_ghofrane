package com.gestionProduit.backEnd.service.clientProduit;


import com.gestionProduit.backEnd.Entity.ClientProduit;
import com.gestionProduit.backEnd.Entity.client;
import com.gestionProduit.backEnd.Entity.dtos.FournisseurClientDTO;
import com.gestionProduit.backEnd.Entity.Produit;
import com.gestionProduit.backEnd.repository.ClientProduitRepository;
import com.gestionProduit.backEnd.repository.ClientRepository;
import com.gestionProduit.backEnd.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClientProduitServiceImpl implements ClientProduitService {

    private static final Logger log = LoggerFactory.getLogger(ClientProduitServiceImpl.class);
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ClientProduitRepository clientProduitRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientProduit> getAllClientProduit() {
        return clientProduitRepository.findAll();
    }

    @Override
    public Optional<ClientProduit> getClientProduitById(Integer id) {
        return clientProduitRepository.findById(id);
    }

    @Override
    public List<ClientProduit> getClientProduitsByClientId(Integer id) {
        Optional<client> clientUser = clientRepository.findById(id);
        if (clientUser.isPresent()) {
            return clientProduitRepository.findByFournisseur(clientUser.get());
        }
        return List.of();
    }

    @Override
    public List<ClientProduit> getClientProduitByProduit(Integer id) {
        Optional<Produit> produit = produitRepository.findById(id);
        if (produit.isPresent()) {
            return clientProduitRepository.findByProduit(produit.get());
        }
        return List.of();
    }

    @Override
    public ClientProduit createClientProduit(ClientProduit produit) {
        return clientProduitRepository.save(produit);
    }

    @Override
    @Transactional
    public List<ClientProduit> createListClientProduit(List<FournisseurClientDTO> list) {
        if (!list.isEmpty()) {
            clientProduitRepository.deleteByProduit(produitRepository.findById(list.get(0).produit()).get());
        }


        list.forEach(el -> {
            ClientProduit clientProduit = new ClientProduit();
            if (el.id() != null)
                clientProduit.setId(el.id());
            clientProduit.setFournisseur(clientRepository.findById(el.fournisseur()).get());
            clientProduit.setProduit(produitRepository.findById(el.produit()).get());
            clientProduit.setPrix(el.prix());
            clientProduit.setQuantite(el.quantite());
            clientProduitRepository.save(clientProduit);
//            clientProduits.add(clientProduit);
        });
        return List.of();
//        return clientProduitRepository.saveAll(clientProduits);
    }

    @Override
    public List<ClientProduit> updateClientProduit(List<ClientProduit> clientProduits, Integer id) {
        return clientProduitRepository.saveAll(clientProduits);
    }

    @Override
    public void removeClientProduitById(Integer id) {
        clientProduitRepository.deleteById(id);
    }
}
