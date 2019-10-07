package sn.sa.filrouge.backspring.contoller;

import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.sa.filrouge.backspring.model.*;
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

    @GetMapping(value = "/lister/compte")
    @PreAuthorize("hasAuthority('ROLE_Wari')")
    public List<Compte> listerCompte(){
        return compteRepository.findAll();
    }

    @GetMapping(value = "/lister/compte/un/partenaire")
    @PreAuthorize("hasAuthority('ROLE_Partenaire')")
    public List<Compte> listerDesCompte(){
        return compteRepository.findComptesByPartenaire(userDetailsService.getUserConnect().getPartenaire());
    }

    @PostMapping(value = "/ajouter/compte", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Compte addCompte(@RequestBody FormCompte comptes){

        Compte compte = new Compte();
        double nbre = (int)(Math.random() * 99999999) + 1;
        nbre *= 999999;
        compte.setNumeroCompte(nbre);
        compte.setDateCreation(new Date());
        compte.setSolde(0);
        compte.setNomBeneficiaire(comptes.getNomBeneficiaire());
        compte.setCodeBank(comptes.getCodeBank());
        Partenaire part = partenaireRepository.findPartenaireByNinea(comptes.getNinea()).orElseThrow();
        compte.setPartenaire(part);
        return compteRepository.save(compte);
    }

    @Autowired
    private DepotRepository depotRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping(value = "/lister/depot")
    @PreAuthorize("hasAuthority('ROLE_Wari')")
    public List<Depot> listerDepots(){
        return depotRepository.findAll();
    }

    @PostMapping(value = "/faire/depot")
    public Depot addDepot(@RequestBody Depot depot) throws Exception {

        User user = userDetailsService.getUserConnect();
        depot.setDateDepot(new Date());
        depot.setCaissier(user);


        Compte compte = compteRepository.findCompteByNumeroCompte(depot.getCompte().getNumeroCompte()).orElseThrow(
                ()->new Exception("Ce compte n'existe pas ")
        );

        if (compte == null){
            System.out.println("Ce compte n'existe pas");
            System.exit(0);
        }

        depot.setCompte(compte);

        compte.setSolde(compte.getSolde() + depot.getMontantDepot());
        compteRepository.save(compte);

        return depotRepository.save(depot);
    }
}
