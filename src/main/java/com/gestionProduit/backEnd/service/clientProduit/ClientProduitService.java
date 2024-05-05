package com.gestionProduit.backEnd.service.clientProduit;

import com.gestionProduit.backEnd.Entity.ClientProduit;
import com.gestionProduit.backEnd.Entity.dtos.FournisseurClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientProduitService {
    List<ClientProduit> getAllClientProduit();
    Optional<ClientProduit> getClientProduitById(Integer id);
    List<ClientProduit> getClientProduitByProduit(Integer id);
    ClientProduit createClientProduit(ClientProduit clientProduit);
    List<ClientProduit> createListClientProduit(List<FournisseurClientDTO> clientProduit);
    List<ClientProduit> updateClientProduit(List<ClientProduit> clientProduit, Integer id);
    void removeClientProduitById(Integer id);
}
