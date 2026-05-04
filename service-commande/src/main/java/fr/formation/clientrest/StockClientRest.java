package fr.formation.clientrest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.Path;

@Path("/stock")
@RegisterRestClient(configKey = "stock-service")
public interface StockClientRest {
}