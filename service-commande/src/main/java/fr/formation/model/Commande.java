package fr.formation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Commande {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer clientId;

  private double prixTotal;
  @OneToMany private List<ProduitCommande> produits;

  public Integer getId() {
    return id;
  }

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public double getPrixTotal() {
    return prixTotal;
  }

  public void setPrixTotal(double prixTotal) {
    this.prixTotal = prixTotal;
  }

  public List<ProduitCommande> getProduits() {
    return produits;
  }

  public void setProduits(List<ProduitCommande> produits) {
    this.produits = produits;
  }

  @Override
  public String toString() {
    return "Commande [prixTotal=" + prixTotal + ", produits=" + produits + "]";
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
