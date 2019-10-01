package sn.sa.filrouge.backspring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column()
    private Date dateDepot;
    @NotBlank
    @Column()
    private double montantDepot;

    @NotBlank
    @JoinColumn(name = "id_compte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Compte compte;

    @NotBlank
    @JoinColumn(name = "id_caissier", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User caissier;

    public Depot() {
    }

    public Depot(@NotBlank Date dateDepot, @NotBlank double montantDepot, @NotBlank Compte compte, @NotBlank User caissier) {
        this.dateDepot = dateDepot;
        this.montantDepot = montantDepot;
        this.compte = compte;
        this.caissier = caissier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public double getMontantDepot() {
        return montantDepot;
    }

    public void setMontantDepot(double montantDepot) {
        this.montantDepot = montantDepot;
    }
}
