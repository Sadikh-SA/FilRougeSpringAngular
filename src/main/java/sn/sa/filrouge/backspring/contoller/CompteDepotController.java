package sn.sa.filrouge.backspring.contoller;

import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.sa.filrouge.backspring.model.Compte;
import sn.sa.filrouge.backspring.model.Depot;
import sn.sa.filrouge.backspring.model.Partenaire;
import sn.sa.filrouge.backspring.model.User;
import sn.sa.filrouge.backspring.repository.CompteRepository;
import sn.sa.filrouge.backspring.repository.DepotRepository;
import sn.sa.filrouge.backspring.repository.PartenaireRepository;
import sn.sa.filrouge.backspring.services.UserDetailsServiceImpl;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/filrouge")
public class CompteDepotController {

    @Autowired
    private PartenaireRepository partenaireRepository;

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(value = "/liste/compte")
    @PreAuthorize("hasAuthority('ROLE_Wari')")
    public List<Compte> listerCompte(){
        return compteRepository.findAll();
    }

    @PostMapping(value = "/ajouter/compte", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Compte addCompte(@RequestBody Compte compte){

        double nbre = (int)(Math.random() * 99999999) + 1;
        nbre *= 999999;
        compte.setNumeroCompte(nbre);
        compte.setDateCreation(new Date());
        compte.setSolde(0);
        compte.setPartenaire(compte.getPartenaire());
        return compteRepository.save(compte);
    }

    @Autowired
    private DepotRepository depotRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping(value = "/liste/depot")
    @PreAuthorize("hasAuthority('ROLE_Wari')")
    public List<Depot> listerDepots(){
        return depotRepository.findAll();
    }

    @PostMapping(value = "/faire/depot", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Depot addDepot(@RequestBody Depot depot) throws Exception {

        User user = userDetailsService.getUserConnect();
        depot.setDateDepot(new Date());
        depot.setCaissier(user);
        depot.setCompte(user.getCompte());

        Compte compte = compteRepository.findCompteById(user.getCompte().getId()).orElseThrow(
                ()->new Exception("Ce compte n'existe pas ")
        );

        compte.setSolde(compte.getSolde() + depot.getMontantDepot());
        compteRepository.save(compte);

        return depotRepository.save(depot);
    }
}
