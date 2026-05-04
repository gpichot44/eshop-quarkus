package model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @UuidGenerator
    private String id;

    private String nom;
    private String prenom;
    private String civilite;

    public Client() {}
    
    public Client(String id, String nom, String prenom, String civilite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getCivilite() {
        return civilite;
    }
    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    
}
