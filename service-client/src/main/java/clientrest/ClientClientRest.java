package clientrest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/client")
@RegisterRestClient(configKey = "client-service")
public interface ClientClientRest {
    
    @GET
    @Path("/api/commande/clientHasCommande/{id}")
    public boolean isDeletable(@PathParam("id") String id);
    
}
