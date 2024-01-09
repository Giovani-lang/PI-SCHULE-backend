package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Classe;
import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Entity.Lemploi;
import com.logonedigital.PI.SCHULE.Entity.Matiere;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.LemploiMapper;
import com.logonedigital.PI.SCHULE.Repository.ClasseRepository;
import com.logonedigital.PI.SCHULE.Repository.EnseignantRepository;
import com.logonedigital.PI.SCHULE.Repository.LemploiRepository;
import com.logonedigital.PI.SCHULE.Repository.MatiereRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.ILemploiService;
import com.logonedigital.PI.SCHULE.dto.lemploi_dto.LemploiRequest;
import com.logonedigital.PI.SCHULE.dto.lemploi_dto.LemploiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LemploiServiceImpl implements ILemploiService {
    private final LemploiRepository lemploiRepo;
    private final LemploiMapper lemploiMapper;
    private final EnseignantRepository enseignantRepo;
    private final MatiereRepository matiereRepo;
    private final ClasseRepository classeRepo;
    @Override
    public LemploiResponse addLemploi(LemploiRequest lemploiRequest) {
        Lemploi lemploi = this.lemploiMapper.fromLemploiRequest(lemploiRequest);
        Enseignant enseignant = this.enseignantRepo.findByEmail(lemploiRequest.getEmail_enseignant())
                .orElseThrow(()-> new RessourceNotFoundException("No teacher matches this email"+lemploiRequest.getEmail_enseignant()));
        lemploi.setEnseignant(enseignant);
        Matiere matiere = this.matiereRepo.findByIntitule(lemploiRequest.getCours())
                        .orElseThrow(()-> new RessourceNotFoundException("This matiere doesn't exist"));
        lemploi.setMatiere(matiere);
        //formatage de l'heure de debut en type localTime;
        LocalTime heure = LocalTime.parse(lemploiRequest.getDebut());
        //Addition de l'heure de debut avec la duree pour avoir l'heure de fin;
        LocalTime resultat = heure.plusHours(lemploiRequest.getDuree());
        //Enregistrement de la date de fin dans sa variable en reconversion vers le type string;
        lemploi.setFin(resultat.toString());
        Classe classe =this.classeRepo.findByNom(lemploiRequest.getNom_classe())
                .orElseThrow(()-> new RessourceNotFoundException("This classe doesn't exit, try again !"));
        lemploi.setClasse(classe);
        return this.lemploiMapper.fromLemploi(this.lemploiRepo.save(lemploi));
    }

    @Override
    public List<LemploiResponse> findAllLemploiByClasse(String classe) {
        List<Lemploi> lemplois =  (List<Lemploi>) this.lemploiRepo.findByClasse(classe);
        List<LemploiResponse> lemploiResponses = new ArrayList<>();
        lemplois.forEach(lempl -> lemploiResponses.add(this.lemploiMapper.fromLemploi(lempl)));
        return lemploiResponses;
    }

//    @Override
//    public List<LemploiResponse> getAllLemploi() {
//        List<Lemploi> lemplois =  this.lemploiRepo.findAll();
//        List<LemploiResponse> lemploiResponses = new ArrayList<>();
//        lemplois.forEach(lempl -> lemploiResponses.add(this.lemploiMapper.fromLemploi(lempl)));
//        return lemploiResponses;
//    }

    @Override
    public LemploiResponse updateLemploi(Long id, LemploiRequest lemploiRequest) {

        Lemploi newlemploi = this.lemploiRepo.findById(id).get();
        Lemploi lemploi = this.lemploiMapper.fromLemploiRequest(lemploiRequest);

        newlemploi.setJour(lemploi.getJour());
        newlemploi.setDebut(lemploi.getDebut());
        //formatage de l'heure de debut en type localTime;
        LocalTime heure = LocalTime.parse(lemploi.getDebut());
        //Addition de l'heure de debut avec la duree pour avoir l'heure de fin;
        LocalTime resultat = heure.plusHours(lemploi.getDuree());
        //Enregistrement de la date de fin dans sa variable en reconversion vers le type string;
        newlemploi.setFin(resultat.toString());
        newlemploi.setDuree(lemploi.getDuree());

        Enseignant enseignant = this.enseignantRepo.findByEmail(lemploiRequest.getEmail_enseignant())
                .orElseThrow(()-> new RessourceNotFoundException("No teacher matches this email"+lemploiRequest.getEmail_enseignant()));
        newlemploi.setEnseignant(enseignant);

        Matiere matiere = this.matiereRepo.findByIntitule(lemploiRequest.getCours())
                .orElseThrow(()-> new RessourceNotFoundException("This matiere doesn't exist"));
        newlemploi.setMatiere(matiere);

        Classe classe =this.classeRepo.findByNom(lemploiRequest.getNom_classe())
                .orElseThrow(()-> new RessourceNotFoundException("This classe doesn't exit, try again !"));
        newlemploi.setClasse(classe);

        return this.lemploiMapper.fromLemploi(this.lemploiRepo.saveAndFlush(newlemploi));
    }

    @Override
    public void deleteLemploi(Long id) {
        this.lemploiRepo.deleteById(id);
    }
}
