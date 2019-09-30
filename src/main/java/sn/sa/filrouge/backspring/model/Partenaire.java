package sn.sa.filrouge.backspring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "partenaires", uniqueConstraints = @UniqueConstraint(columnNames = {"ninea"}))
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, unique = true)
    private String ninea;
    @Column(length = 75)
    private String localisation;
    @Column(length = 75)
    private String domaineActivite;
    @Column(length = 75)
    private Date dateCreation;
    @Column()
    private boolean statut;

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
