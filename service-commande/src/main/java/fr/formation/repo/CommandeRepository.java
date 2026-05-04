package fr.formation.repo;

import fr.formation.model.Commande;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CommandeRepository implements PanacheRepositoryBase<Commande, Integer> {

  public List<Commande> findAllByClientId(Integer clientId) {
    return list("clientId", clientId);
  }
}
