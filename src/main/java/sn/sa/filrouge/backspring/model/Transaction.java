package sn.sa.filrouge.backspring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String nomEnvoyeur;
    @Column(length = 50)
    private String prenomEnvoyeur;
    @Column(length = 75)
    private String adresseEnvoyeur;
    @Column(length = 25)
    private String telEnvoyeur;
    @Column()
    @Size(min = 9, max = 10)
    private double CNIEnvoyeur;
    @Column(length = 50)
    private String nomBeneficiaire;
    @Column(length = 50)
    private String prenomBeneficiaire;
    @Column(length = 75, nullable = true)
    private String adresseBeneficiaire;
    @Column(length = 25)
    private String telBeneficiaire;
    @Column(nullable = true)
    @Size(min = 9, max = 10)
    private double CNIBeneficiaire;
    @Column()
    private double montantEnvoyer;
    @Column()
    private double totalEnvoyer;
    @Column(nullable = true)
    private double montantRetirer;
    @Column()
    private Date dateEnvoie;
    @Column( nullable = true)
    private Date dateRetrait;
    @Column()
    private double commissionEnvoi;
    @Column()
    private double commissionEtat;
    @Column()
    private double commissionWari;
    @Column( nullable = true)
    private double commissionRetrait;
    @Column()
    private boolean type;
    @Column()
    @Size(min = 9, max = 10)
    private double numeroTransaction;

    @NotBlank
    @JoinColumn(name = "id_commission", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Commission CommissionTTC;

    @NotBlank
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User utilisateur;

    @NotBlank
    @JoinColumn(name = "id_users", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userRetrait;

    public Transaction() {
    }

    public Transaction(String nomEnvoyeur, String prenomEnvoyeur, String adresseEnvoyeur, String telEnvoyeur, @Size(min = 9, max = 10) double CNIEnvoyeur, String nomBeneficiaire, String prenomBeneficiaire, String adresseBeneficiaire, String telBeneficiaire, @Size(min = 9, max = 10) double CNIBeneficiaire, double montantEnvoyer, double totalEnvoyer, double montantRetirer, Date dateEnvoie, Date dateRetrait, double commissionEnvoi, double commissionEtat, double commissionWari, double commissionRetrait, boolean type, @Size(min = 9, max = 10) double numeroTransaction, @NotBlank Commission commissionTTC, @NotBlank User utilisateur, @NotBlank User userRetrait) {
        this.nomEnvoyeur = nomEnvoyeur;
        this.prenomEnvoyeur = prenomEnvoyeur;
        this.adresseEnvoyeur = adresseEnvoyeur;
        this.telEnvoyeur = telEnvoyeur;
        this.CNIEnvoyeur = CNIEnvoyeur;
        this.nomBeneficiaire = nomBeneficiaire;
        this.prenomBeneficiaire = prenomBeneficiaire;
        this.adresseBeneficiaire = adresseBeneficiaire;
        this.telBeneficiaire = telBeneficiaire;
        this.CNIBeneficiaire = CNIBeneficiaire;
        this.montantEnvoyer = montantEnvoyer;
        this.totalEnvoyer = totalEnvoyer;
        this.montantRetirer = montantRetirer;
        this.dateEnvoie = dateEnvoie;
        this.dateRetrait = dateRetrait;
        this.commissionEnvoi = commissionEnvoi;
        this.commissionEtat = commissionEtat;
        this.commissionWari = commissionWari;
        this.commissionRetrait = commissionRetrait;
        this.type = type;
        this.numeroTransaction = numeroTransaction;
        CommissionTTC = commissionTTC;
        this.utilisateur = utilisateur;
        this.userRetrait = userRetrait;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEnvoyeur() {
        return nomEnvoyeur;
    }

    public void setNomEnvoyeur(String nomEnvoyeur) {
        this.nomEnvoyeur = nomEnvoyeur;
    }

    public String getPrenomEnvoyeur() {
        return prenomEnvoyeur;
    }

    public void setPrenomEnvoyeur(String prenomEnvoyeur) {
        this.prenomEnvoyeur = prenomEnvoyeur;
    }

    public String getAdresseEnvoyeur() {
        return adresseEnvoyeur;
    }

    public void setAdresseEnvoyeur(String adresseEnvoyeur) {
        this.adresseEnvoyeur = adresseEnvoyeur;
    }

    public String getTelEnvoyeur() {
        return telEnvoyeur;
    }

    public void setTelEnvoyeur(String telEnvoyeur) {
        this.telEnvoyeur = telEnvoyeur;
    }

    public double getCNIEnvoyeur() {
        return CNIEnvoyeur;
    }

    public void setCNIEnvoyeur(double CNIEnvoyeur) {
        this.CNIEnvoyeur = CNIEnvoyeur;
    }

    public String getNomBeneficiaire() {
        return nomBeneficiaire;
    }

    public void setNomBeneficiaire(String nomBeneficiaire) {
        this.nomBeneficiaire = nomBeneficiaire;
    }

    public String getPrenomBeneficiaire() {
        return prenomBeneficiaire;
    }

    public void setPrenomBeneficiaire(String prenomBeneficiaire) {
        this.prenomBeneficiaire = prenomBeneficiaire;
    }

    public String getAdresseBeneficiaire() {
        return adresseBeneficiaire;
    }

    public void setAdresseBeneficiaire(String adresseBeneficiaire) {
        this.adresseBeneficiaire = adresseBeneficiaire;
    }

    public String getTelBeneficiaire() {
        return telBeneficiaire;
    }

    public void setTelBeneficiaire(String telBeneficiaire) {
        this.telBeneficiaire = telBeneficiaire;
    }

    public double getCNIBeneficiaire() {
        return CNIBeneficiaire;
    }

    public void setCNIBeneficiaire(double CNIBeneficiaire) {
        this.CNIBeneficiaire = CNIBeneficiaire;
    }

    public double getMontantEnvoyer() {
        return montantEnvoyer;
    }

    public void setMontantEnvoyer(double montantEnvoyer) {
        this.montantEnvoyer = montantEnvoyer;
    }

    public double getTotalEnvoyer() {
        return totalEnvoyer;
    }

    public void setTotalEnvoyer(double totalEnvoyer) {
        this.totalEnvoyer = totalEnvoyer;
    }

    public double getMontantRetirer() {
        return montantRetirer;
    }

    public void setMontantRetirer(double montantRetirer) {
        this.montantRetirer = montantRetirer;
    }

    public Date getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(Date dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public double getCommissionEnvoi() {
        return commissionEnvoi;
    }

    public void setCommissionEnvoi(double commissionEnvoi) {
        this.commissionEnvoi = commissionEnvoi;
    }

    public double getCommissionEtat() {
        return commissionEtat;
    }

    public void setCommissionEtat(double commissionEtat) {
        this.commissionEtat = commissionEtat;
    }

    public double getCommissionWari() {
        return commissionWari;
    }

    public void setCommissionWari(double commissionWari) {
        this.commissionWari = commissionWari;
    }

    public double getCommissionRetrait() {
        return commissionRetrait;
    }

    public void setCommissionRetrait(double commissionRetrait) {
        this.commissionRetrait = commissionRetrait;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public double getNumeroTransaction() {
        return numeroTransaction;
    }

    public void setNumeroTransaction(double numeroTransaction) {
        this.numeroTransaction = numeroTransaction;
    }


}
