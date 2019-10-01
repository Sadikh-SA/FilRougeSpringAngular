package sn.sa.filrouge.backspring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@Table(name = "partenaires", uniqueConstraints = @UniqueConstraint(columnNames = {"ninea"}))
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(length = 100, unique = true)
    private String ninea;
    @NotBlank
    @Column(length = 75)
    private String localisation;
    @NotBlank
    @Column(length = 75)
    private String domaineActivite;
    @NotBlank
    @Column(length = 75)
    private Date dateCreation;
    @NotBlank
    @Column()
    private boolean statut;

    public Partenaire(@NotBlank String ninea, @NotBlank String localisation, @NotBlank String domaineActivite, @NotBlank Date dateCreation, @NotBlank boolean statut) {
        this.ninea = ninea;
        this.localisation = localisation;
        this.domaineActivite = domaineActivite;
        this.dateCreation = dateCreation;
        this.statut = statut;
    }

    public Partenaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDomaineActivite() {
        return domaineActivite;
    }

    public void setDomaineActivite(String domaineActivite) {
        this.domaineActivite = domaineActivite;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
}
