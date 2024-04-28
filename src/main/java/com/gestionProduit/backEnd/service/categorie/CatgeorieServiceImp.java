package com.gestionProduit.backEnd.service.categorie;

import com.gestionProduit.backEnd.Entity.Categorie;
import com.gestionProduit.backEnd.Entity.Produit;
import com.gestionProduit.backEnd.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatgeorieServiceImp implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public Optional<Categorie> getCategorieById(Integer id) {
        return categorieRepository.findById(id);
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie, Integer id) {
        if (categorieRepository.findById(id).isPresent()) {
            return categorieRepository.save(categorie);
        }
        return null;
    }

    @Override
    public void removeCategorieById(Integer id) {
        categorieRepository.deleteById(id);
    }
}
