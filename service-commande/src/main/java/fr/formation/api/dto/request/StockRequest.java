package fr.formation.api.dto.request;

public class StockRequest {

    public Integer produitId;
    public int quantite;

    public StockRequest() {}

    public StockRequest(Integer produitId, int quantite) {
        this.produitId = produitId;
        this.quantite = quantite;
    }
}