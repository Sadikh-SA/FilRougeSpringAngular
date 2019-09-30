package sn.sa.filrouge.backspring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Table(name = "comptes", uniqueConstraints = @UniqueConstraint(columnNames = {"numeroCompte"}))
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private double numeroCompte;
    @Column(unique = true)
    @Size(min = 6, max = 6, message = "Le code banque est un nombre de 6 caratères")
    private double codeBank;
    @Column(length = 75)
    private String nomBeneficiaire;
    @Column()
    private double solde;
    @Column()
    private Date dateCreation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(double numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getCodeBank() {
        return codeBank;
    }

    public void setCodeBank(double codeBank) {
        this.codeBank = codeBank;
    }

    public String getNomBeneficiaire() {
        return nomBeneficiaire;
    }

    public void setNomBeneficiaire(String nomBeneficiaire) {
        this.nomBeneficiaire = nomBeneficiaire;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
