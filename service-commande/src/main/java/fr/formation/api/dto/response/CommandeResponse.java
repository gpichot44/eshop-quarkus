package fr.formation.api.dto.response;

import fr.formation.model.Commande;
import fr.formation.model.ProduitCommande;
import java.util.List;

public record CommandeResponse(
    Integer id,
    Integer clientId,
    String nomClient,
    double prixTotal,
    List<ProduitCommandeResponse> produits) {

  public static CommandeResponse convert(Commande commande, String nomClient) {
    return new CommandeResponse(
        commande.getId(),
        commande.getClientId(),
        nomClient,
        commande.getPrixTotal(),
        convertProduits(commande.getProduits()));
  }

  private static List<ProduitCommandeResponse> convertProduits(List<ProduitCommande> produits) {
    if (produits == null) {
      return List.of();
    }

    return produits.stream()
        .map(ProduitCommandeResponse::convert)
        .toList();
  }

  public record ProduitCommandeResponse(
      Integer id,
      String libelle,
      double prix,
      int quantite) {

    private static ProduitCommandeResponse convert(ProduitCommande produit) {
      return new ProduitCommandeResponse(
          produit.getId(),
          produit.getLibelle(),
          produit.getPrix(),
          produit.getQuantite());
    }
  }
}
