package api.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record CreateClientRequest(@NotEmpty String nom, @NotEmpty String prenom, @NotEmpty String civilite) {

}
