package com.gestionProduit.backEnd.service.client;

import com.gestionProduit.backEnd.Entity.client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<client> getAllClinet();
    Optional<client> getClinetById(Integer id);
    client createClient(client clientInfo);
    List<client> getProduitByIdCategorie(Integer id);
    client updateClinet(client clientInfo,Integer id);
    void removeClinetById(Integer id);
    void affectUserToCategory(Integer idUser,Integer idCategory);
}
