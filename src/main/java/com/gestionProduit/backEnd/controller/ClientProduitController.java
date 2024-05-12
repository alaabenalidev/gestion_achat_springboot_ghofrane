package com.gestionProduit.backEnd.controller;

import com.gestionProduit.backEnd.Entity.ClientProduit;
import com.gestionProduit.backEnd.Entity.dtos.FournisseurClientDTO;
import com.gestionProduit.backEnd.service.clientProduit.ClientProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client-produit")
public class ClientProduitController {
    @Autowired
    private ClientProduitService clientProduitService;

    @GetMapping("/list")
    public ResponseEntity<List<ClientProduit>> getAllClientProduit() {
        return new ResponseEntity<>(clientProduitService.getAllClientProduit(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientProduitById(@PathVariable Integer id) {
        Optional<ClientProduit> optionalProduit = clientProduitService.getClientProduitById(id);
        if (optionalProduit.isPresent()) {
            return new ResponseEntity<>(optionalProduit.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Produit not found for id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/fournisseur")
    public ResponseEntity<?> getClientProduitByProduitId(@PathVariable Integer id) {
        List<ClientProduit> produits = clientProduitService.getClientProduitsByClientId(id);

        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @GetMapping("/{id}/produit")
    public ResponseEntity<?> getClientProduitByIdProduit(@PathVariable Integer id) {
        List<ClientProduit> clientProduits = clientProduitService.getClientProduitByProduit(id);

        return new ResponseEntity<>(clientProduits, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<List<ClientProduit>> createProduit(@RequestBody List<FournisseurClientDTO> fournisseurClientDTOList) {
        return new ResponseEntity<>(clientProduitService.createListClientProduit(fournisseurClientDTOList), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<ClientProduit>> updateProduit(@RequestBody List<ClientProduit> clientProduits, @PathVariable Integer id) {
        return new ResponseEntity<>(clientProduitService.updateClientProduit(clientProduits, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduitByid(@PathVariable Integer id) {
        clientProduitService.removeClientProduitById(id);
        return ResponseEntity.noContent().build();
    }

}
