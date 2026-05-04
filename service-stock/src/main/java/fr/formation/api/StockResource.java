package fr.formation.api;

import java.util.Map;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import fr.formation.api.dto.request.CreateOrUpdateStockRequest;
import fr.formation.clientRest.ProduitClientRest;
import fr.formation.model.Stock;
import fr.formation.repo.StockRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/stock")
public class StockResource {

    @RestClient
    @Inject
    private ProduitClientRest produitClientRest;

    @Inject
    private StockRepository repository;

    public StockResource(StockRepository repository) {
        this.repository = repository;
    }

    @GET
    @Path("/{produitId}")
    public Stock findStockByProduitId(@PathParam("produitId") Integer produitId) {
        return this.repository.findById(produitId);
    }

    @Transactional
    @POST
    public Response create(@Valid CreateOrUpdateStockRequest request) {

        try {
            boolean findProduitById = this.produitClientRest.findProduitById(request.produitId());

            if (!findProduitById) {
                return Response.status(Response.Status.FORBIDDEN)
                        .entity(Map.of("findProduit", false))
                        .build();
            }
        }

        catch (Exception e) {}

        Stock stock = new Stock();

        stock.setQuantite(request.quantite());
        stock.setProduitId(request.produitId());

        this.repository.persist(stock);

        return Response.status(Response.Status.CREATED)
                .entity(stock.getId())
                .build();

    }



}