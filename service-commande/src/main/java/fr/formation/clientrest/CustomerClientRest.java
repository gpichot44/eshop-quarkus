package fr.formation.clientrest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/client")
@RegisterRestClient(configKey = "client-service")
public interface CustomerClientRest {

    @GET
    @Path("/client/{id}")
    public String findClient(@PathParam("id") String id);

}
