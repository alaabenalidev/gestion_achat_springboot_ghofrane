package com.gestionProduit.backEnd.service.categorie;

import com.gestionProduit.backEnd.Entity.Categorie;
import com.gestionProduit.backEnd.Entity.Produit;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    List<Categorie> getAllCategorie();
    Optional<Categorie> getCategorieById(Integer id);
    Categorie createCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie,Integer id);
    void removeCategorieById(Integer id);
}
