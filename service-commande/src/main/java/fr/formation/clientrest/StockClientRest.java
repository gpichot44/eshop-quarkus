package fr.formation.clientrest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import fr.formation.api.dto.request.StockRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/stock")
@RegisterRestClient(configKey = "stock-service")
public interface StockClientRest {
    	//Vérifier la disponibilité
	 @GET
	    @Path("/check/{produitId}/{quantite}")
	    boolean checkStock(@PathParam("produitId") Integer produitId,
	                       @PathParam("quantite") int quantite);
	 
	 //Après ajout effectif, diminue le stock
	 @POST
	    @Path("/remove")
	    void removeStock(StockRequest request);

}