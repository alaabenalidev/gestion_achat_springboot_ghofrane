package com.gestionProduit.backEnd.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "client")
public class client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @NotEmpty
    @NotNull
    private String nom;
    @NotBlank
    @NotEmpty
    @NotNull
    private String prenom;
    @NotBlank
    @NotEmpty
    @NotNull
    private String adresse;
    @Column(unique = true)
    @Length(min = 8, max = 8)
    private String num_tel;
    @Email
    private String email;
    @ManyToOne
    private Categorie categorie;

}
