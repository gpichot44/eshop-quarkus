package fr.formation.clientrest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Path;

@Path("/client")
@RegisterRestClient(configKey = "client-service")
public interface CustomerClientRest {

}
