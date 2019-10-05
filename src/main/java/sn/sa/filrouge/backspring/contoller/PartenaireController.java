package sn.sa.filrouge.backspring.contoller;

import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.sa.filrouge.backspring.model.Partenaire;
import sn.sa.filrouge.backspring.repository.PartenaireRepository;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/filrouge")
public class PartenaireController {

    @Autowired
    private PartenaireRepository partenaireRepository;

    @GetMapping(value = "/liste/partenaire")
    @PreAuthorize("hasAuthority('ROLE_Wari')")
    public List<Partenaire> listerPartenaire(){
        return partenaireRepository.findAll();
    }

    @PostMapping(value = "/ajouter/partenaire")
    @PreAuthorize("hasAuthority('ROLE_Wari')")
    public Partenaire addPartenaire(Partenaire partenaire){

        partenaire.setDateCreation(new Date());
        partenaire.setStatut(true);



        return partenaireRepository.save(partenaire);
    }
}
