package sn.sa.filrouge.backspring.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.sa.filrouge.backspring.model.Profil;
import sn.sa.filrouge.backspring.repository.CommissionRepository;
import sn.sa.filrouge.backspring.repository.ProfilRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/filrouge")
public class ProfilCommisionController {

    @Autowired
    private ProfilRepository profilRepository;
    @Autowired
    private CommissionRepository commissionRepository;

    @GetMapping(value = "/liste/profil")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Profil> listerService(){
        return profilRepository.findAll();
    }

    @PostMapping(value = "/ajouter/profil", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Profil addProfil(@RequestBody Profil profil){
        return profilRepository.save(profil);
    }
}
