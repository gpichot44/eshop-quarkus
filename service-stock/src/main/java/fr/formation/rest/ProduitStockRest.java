package fr.formation.rest;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/stock")
@RegisterRestClient(configKey = "produit-service")
public interface ProduitStockRest {

    @GET
    @Path("/quantiteByProduit")
    public int findQuantiteByProduit();

}
