package fr.formation.api.dto.request;

import jakarta.validation.constraints.Positive;

public record CreateOrUpdateStockRequest(@Positive int quantite, Integer produitId) {

}