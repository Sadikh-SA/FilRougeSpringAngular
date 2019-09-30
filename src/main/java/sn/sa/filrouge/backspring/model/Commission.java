package sn.sa.filrouge.backspring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column()
    private double borneInferieure;
    @Column()
    private double borneSuperieure;
    @Column()
    private double valeur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBorneInferieure() {
        return borneInferieure;
    }

    public void setBorneInferieure(double borneInferieure) {
        this.borneInferieure = borneInferieure;
    }

    public double getBorneSuperieure() {
        return borneSuperieure;
    }

    public void setBorneSuperieure(double borneSuperieure) {
        this.borneSuperieure = borneSuperieure;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}
