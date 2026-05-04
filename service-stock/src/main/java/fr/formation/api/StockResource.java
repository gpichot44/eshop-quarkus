package fr.formation.api;

import fr.formation.repo.StockRepository;
import jakarta.ws.rs.Path;

@Path("/api/stock")
public class StockResource {
    private final StockRepository repository;

    public StockResource(StockRepository repository) {
        this.repository = repository;
    }

}