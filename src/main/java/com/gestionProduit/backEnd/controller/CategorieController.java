package com.gestionProduit.backEnd.controller;

import com.gestionProduit.backEnd.Entity.Categorie;
import com.gestionProduit.backEnd.service.categorie.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/List")
    public ResponseEntity<List<Categorie>> getAllCategorie(){
        return new ResponseEntity<>(categorieService.getAllCategorie(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>  getCategorieById(@PathVariable Integer id){
        Optional<Categorie> optionalCategorie = categorieService.getCategorieById(id);
        if(optionalCategorie.isPresent()){
            return new ResponseEntity<>(optionalCategorie.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Categorie not found for id: "+id, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorieInfo){
        return  new ResponseEntity<>(categorieService.createCategorie(categorieInfo),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie categorieInfo,@PathVariable Integer id){
        return  new ResponseEntity<>(categorieService.updateCategorie(categorieInfo,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCategorieyid(@PathVariable Integer id){
        categorieService.removeCategorieById(id);
        return  ResponseEntity.noContent().build();
    }
}
