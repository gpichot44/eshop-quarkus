package fr.formation.repo;

import fr.formation.model.Stock;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StockRepository implements PanacheRepositoryBase<Stock, Integer>{

}
