package sn.sa.filrouge.backspring.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserPartenaireCompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=3, max = 50)
    private String prenom;

    @NotBlank
    @Size(min=3, max = 50)
    private String adresse;

    @NotBlank
    @Size(min=7, max = 20)
    private String tel;

    @NotBlank
    @Size(min=3, max = 50)
    private boolean statut;

    @NotBlank
    @Size(min=3, max = 50)
    private String profil;

    @NotBlank
    @Size(min=3, max = 50)
    private Date dateCreation;

    @Size(min=3, max = 50)
    private String imageName;

    @NotBlank
    @JoinColumn(name = "id_partenaire", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Partenaire partenaire;

    @JoinColumn(name = "id_compte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Compte compte;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }


    /**
     * Parti partenaire
     */

    @NotBlank
    @Column(length = 100, unique = true)
    private String ninea;
    @NotBlank
    @Column(length = 75)
    private String localisation;
    @NotBlank
    @Column(length = 75)
    private String domaineActivite;

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

    /**
     * Parti Compte
     */

    @Column(unique = true)
    private double numeroCompte;
    @Column(unique = true)
    private double codeBank;
    @NotBlank
    @Column(length = 75)
    private String nomBeneficiaire;
    @Column()
    private double solde;

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

}
