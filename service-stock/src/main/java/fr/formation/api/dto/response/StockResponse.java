package fr.formation.api.dto.response;

import fr.formation.model.Stock;

public record StockResponse(Integer id, int quantite, Integer produitId) {
    public static StockResponse convert(Stock stock) {
        return new StockResponse(stock.getId(), stock.getQuantite(), stock.getProduitId());
    }
}