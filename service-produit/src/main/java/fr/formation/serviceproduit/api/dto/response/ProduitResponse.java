package fr.formation.serviceproduit.api.dto.response;

import java.math.BigDecimal;

import fr.formation.serviceproduit.model.Produit;


public class ProduitResponse {
    private Integer id;
    private String libelle;
    private BigDecimal prix;
    private boolean notable;

    public static ProduitResponse convert(Produit produit) {
        ProduitResponse resp = new ProduitResponse();

        resp.setId(produit.getId());
        resp.setLibelle(produit.getLibelle());
        resp.setPrix(produit.getPrix());
        resp.setNotable(produit.isNotable());
        return resp;
    }
}
