package api.dto.response;

public record ClientResponse(String id, String nom, String prenom, String civilite) {
    public static ClientResponse convert(model.Client client) {
        return new ClientResponse(client.getId(), client.getNom(), client.getPrenom(), client.getCivilite());
    }
}
