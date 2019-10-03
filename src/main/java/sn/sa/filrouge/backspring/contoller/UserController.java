package sn.sa.filrouge.backspring.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sn.sa.filrouge.backspring.model.*;
import sn.sa.filrouge.backspring.repository.*;
import sn.sa.filrouge.backspring.services.UserDetailsServiceImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/filrouge")
public class UserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PartenaireRepository partenaireRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private ProfilRepository profilRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;


    @PostMapping(value = "/ajouter/partenaire/user", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addUserPartenaireCompte(@RequestBody UserPartenaireCompte userPartenaireCompte) throws Exception {


        User user = new User();
        Partenaire partenaire = new Partenaire();
        Compte compte = new Compte();
        User users = userDetailsService.getUserConnect();
        Set<Role> roles = new HashSet<>();
        Role role=new Role();

        user.setUsername(userPartenaireCompte.getUsername());
        user.setEmail(userPartenaireCompte.getEmail());
        user.setAdresse(userPartenaireCompte.getAdresse());
        user.setDateCreation(new Date());
        user.setName(userPartenaireCompte.getName());
        user.setPrenom(userPartenaireCompte.getPrenom());
        user.setImageName(userPartenaireCompte.getImageName());
        user.setProfil(userPartenaireCompte.getProfil());
        user.setTel(userPartenaireCompte.getTel());
        user.setPassword(encoder.encode(userPartenaireCompte.getPassword()));

        Profil profil = profilRepository.findById(Integer.parseInt(userPartenaireCompte.getProfil())).orElseThrow(
                ()->new Exception("Ce Profil n'existe pas ")
        );

        switch (profil.getLibelle()){
            case "Partenaire":

                /**
                 * Parti ajout partenaire
                 */
                partenaire.setDateCreation(new Date());
                partenaire.setStatut(true);
                partenaire.setNinea(userPartenaireCompte.getNinea());
                partenaire.setLocalisation(userPartenaireCompte.getLocalisation());
                partenaire.setDomaineActivite(userPartenaireCompte.getDomaineActivite());
                /**
                 * Parti ajout Compte Partenaire
                 */
                double nbre = (int)(Math.random() * 99999999) + 1;
                nbre *= 999999;
                compte.setNumeroCompte(nbre);
                compte.setDateCreation(new Date());
                compte.setSolde(0);
                compte.setPartenaire(partenaire);
                compte.setCodeBank(userPartenaireCompte.getCodeBank());
                compte.setNomBeneficiaire(userPartenaireCompte.getNomBeneficiaire());
                /**
                 * Continuation Ajout user
                 */
                user.setPartenaire(partenaire);
                user.setCompte(compte);
                user.setStatut(true);
                role.setId((long) 4);
                roles.add(role);
                user.setRoles(roles);

                partenaireRepository.save(partenaire);
                compteRepository.save(compte);
                break;

            case "Admin-Partenaire":

                user.setPartenaire(users.getPartenaire());
                role.setId((long) 5);
                roles.add(role);
                user.setRoles(roles);
                break;

            case "Utilisateur":
                user.setPartenaire(users.getPartenaire());
                role.setId((long) 7);
                roles.add(role);
                user.setRoles(roles);
                break;

            case "Super-Admin":
                user.setPartenaire(users.getPartenaire());
                role.setId((long) 3);
                roles.add(role);
                user.setRoles(roles);
                break;

            case "Caissier":
                user.setPartenaire(users.getPartenaire());
                role.setId((long) 6);
                roles.add(role);
                user.setRoles(roles);
                break;
        }

        userRepository.save(user);
    }
}
