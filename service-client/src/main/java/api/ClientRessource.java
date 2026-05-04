package api;

import java.util.Map;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import api.dto.request.CreateClientRequest;
import clientrest.ClientClientRest;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
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
    public ClientResponse findById(@PathParam("id") Integer id) {
        log.debug("Recherche du client {} ...", id);

        return ClientResponse.convert(this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new));
    }

    @GET
    @Path("/nom-by-id/{id}")
    public String findById(@PathParam("id") Integer id) {
        log.debug("Recherche du nom du client {} ...", id);

        return this.repository.findByIdOptional(id).getNom().orElseThrow(NotFoundException::new);
    }

    @Transactional
    @POST
    public Response create(@Valid CreateClientRequest request) {
        log.debug("Création d'un nouveau Client ...");

        Client Client = new Client();

        Client.setNom(request.nom());
        Client.setPrenom(request.prenom());
        Client.setCivilite(request.civilite());

        this.repository.persist(Client);

        log.debug("Client {} créé !", Client.getId());

        return Response.status(Response.Status.CREATED)
            .entity(Client.getId())
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
