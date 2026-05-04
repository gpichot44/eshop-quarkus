package fr.formation.clientrest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/produit")
@RegisterRestClient(configKey = "produit-service")
public interface ProduitClientRest {

    @GET
    @Path("/produit/{id}")
    public String findProduit(@PathParam("id") String id);
}
