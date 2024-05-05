package com.gestionProduit.backEnd.controller;

import com.gestionProduit.backEnd.Entity.Categorie;
import com.gestionProduit.backEnd.Entity.Commande;
import com.gestionProduit.backEnd.service.Commande.CommandeService;
import com.gestionProduit.backEnd.service.categorie.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping("/List")
    public ResponseEntity<List<Commande>> getAllCommande(){
        return new ResponseEntity<>(commandeService.getAllCommande(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>  getCommandeById(@PathVariable Integer id){
        Optional<Commande> optionalCategorie = commandeService.getCommandeById(id);
        if(optionalCategorie.isPresent()){
            return new ResponseEntity<>(optionalCategorie.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Categorie not found for id: "+id, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Commande> createCategorie(@RequestBody Commande commandeInfo){
        return  new ResponseEntity<>(commandeService.createCommande(commandeInfo),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCategorie(@RequestBody Commande commandeInfo,@PathVariable Integer id){
        return  new ResponseEntity<>(commandeService.updateCommande(commandeInfo,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCategorieyid(@PathVariable Integer id){
        commandeService.removeCommandeById(id);
        return  ResponseEntity.noContent().build();
    }
}
