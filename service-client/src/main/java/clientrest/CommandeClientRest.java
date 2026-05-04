package clientrest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/commande")
@RegisterRestClient(configKey = "commande-service")
public interface CommandeClientRest {
    
    @GET
    @Path("/clientHasCommande/{id}")
    public boolean isDeletable(@PathParam("id") String id);
    
}
