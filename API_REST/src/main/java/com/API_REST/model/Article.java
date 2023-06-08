package com.API_REST.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data // Permet de cree des setter et getter pour chaque attribut de cette classe
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity // @Entity est une annotation qui indique que la classe correspond à une table de la base de données.
@Table(name = "article") // @Table(name=”produit”) indique le nom de la table associée.
public class Article extends AbstractEntity {

    @Column(name = "codearticle") //  les attributs sont annotés avec @Column pour faire le lien avec le nom du champ de la table.
    private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prixunitaireht")
    private BigDecimal prixUnitaireHt;

    @Column(name = "tauxtva")
    private BigDecimal tauxTva;

    @Column(name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    @OneToMany(mappedBy = "article") // @OneToMany : cette annotation permet de spécifier une relation ‘une à plusieurs’. Pour un produit, il y a plusieurs commentaires possibles.
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @OneToMany(mappedBy = "article")
    private List<MvtStk> mvtStks;

}