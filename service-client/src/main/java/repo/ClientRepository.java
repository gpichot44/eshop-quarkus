package repo;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import model.Client;

@ApplicationScoped
public class ClientRepository implements PanacheRepositoryBase<Client, String> {

}
