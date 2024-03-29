package sn.sa.filrouge.backspring.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=1, max = 50)
    private String name;

    @NotBlank
    @Size(min=1, max = 50)
    private String prenom;

    @NotBlank
    @Size(min=3, max = 50)
    private String adresse;

    @NotBlank
    @Size(min=7, max = 20)
    private String tel;

    private boolean statut;

    @NotBlank
    private String profil;

    private Date dateCreation;

    @Size(min=1, max = 50)
    private String imageName;

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

    public User() {}

    public User(@NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String prenom, @NotBlank @Size(min = 3, max = 50) String adresse, @NotBlank @Size(min = 7, max = 20) String tel, @NotBlank @Size(min = 3, max = 50) boolean statut, @NotBlank @Size(min = 3, max = 50) String profil, @NotBlank @Size(min = 3, max = 50) Date dateCreation, @Size(min = 3, max = 50) String imageName, @NotBlank Partenaire partenaire, Compte compte, @NotBlank @Size(min = 3, max = 50) String username, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 6, max = 100) String password, Set<Role> roles) {
        this.name = name;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.statut = statut;
        this.profil = profil;
        this.dateCreation = dateCreation;
        this.imageName = imageName;
        this.partenaire = partenaire;
        this.compte = compte;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String name, String username, String email, String password, String adresse, String prenom, String tel, String imageName, boolean statut, Partenaire partenaire, Compte compte) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.imageName = imageName;
        this.statut = statut;
        this.partenaire = partenaire;
        this.compte = compte;
    }

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
}