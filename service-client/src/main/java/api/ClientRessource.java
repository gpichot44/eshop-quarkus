package api;

import java.util.List;
import java.util.Map;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import api.dto.request.CreateClientRequest;
import api.dto.response.ClientResponse;
import clientrest.ClientClientRest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import model.Client;
import repo.ClientRepository;

@Path("/api/client")
public class ClientRessource {

private static Logger log = LoggerFactory.getLogger(ClientRessource.class);

    @RestClient
    @Inject
    private ClientClientRest clientClientRest;

    @Inject
    private ClientRepository repository;
    
    @GET
    public List<ClientResponse> findAll(){
        log.debug("Liste des clients ...");

        return this.repository.findAll().stream().map(ClientResponse::convert).toList();
    }

    @GET
    @Path("/{id}")
    public ClientResponse findById(@PathParam("id") String id) {
        log.debug("Recherche du client {} ...", id);

        return ClientResponse.convert(this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new));
    }

    @GET
    @Path("/nom-by-id/{id}")
    public String findNomById(@PathParam("id") String id) {
        log.debug("Recherche du nom du client {} ...", id);

        return this.repository.findByIdOptional(id)
            .orElseThrow(NotFoundException::new)
            .getNom();
    }

    @Transactional
    @POST
    public Response create(@Valid CreateClientRequest request) {
        log.debug("Création d'un nouveau Client ...");

        Client client = new Client();

        client.setNom(request.nom());
        client.setPrenom(request.prenom());
        client.setCivilite(request.civilite());

        this.repository.persist(client);

        log.debug("Client {} créé !", client.getId());

        return Response.status(Response.Status.CREATED)
            .entity(client.getId())
            .build()
        ;
    }

    @Transactional
    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") String id) {
        boolean isDeletable = this.clientClientRest.isDeletable(id);

        if (!isDeletable) {
            log.debug("Ce client {} a déjà passé une commande et ne peut être supprimé !", id);

            return Response.status(Response.Status.FORBIDDEN)
                .entity(Map.of("deletable", false))
                .build()
            ;
        }

        log.debug("Suppression du Client {} ...", id);

        this.repository.deleteById(id);

        log.debug("Client {} supprimé !", id);

        return Response.status(Response.Status.OK
        )
            .entity(id)
            .build()
        ;
    }
}
