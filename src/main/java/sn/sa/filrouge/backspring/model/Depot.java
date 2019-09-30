package sn.sa.filrouge.backspring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column()
    private Date dateDepot;
    @Column()
    private double montantDepot;

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
