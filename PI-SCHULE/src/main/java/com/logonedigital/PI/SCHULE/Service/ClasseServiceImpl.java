package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Classe;
import com.logonedigital.PI.SCHULE.Entity.Filiere;
import com.logonedigital.PI.SCHULE.Entity.Option;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.ClasseMapper;
import com.logonedigital.PI.SCHULE.Repository.ClasseRepository;
import com.logonedigital.PI.SCHULE.Repository.FiliereRepository;
import com.logonedigital.PI.SCHULE.Repository.OptionRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IClasseService;
import com.logonedigital.PI.SCHULE.dto.classe_dto.ClasseRequest;
import com.logonedigital.PI.SCHULE.dto.classe_dto.ClasseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClasseServiceImpl implements IClasseService {

    private final ClasseRepository classeRepo;
    private final ClasseMapper classeMapper;
    private final FiliereRepository filiereRepo;
    private final OptionRepository optionRepo;
    @Override
    public ClasseResponse addClasse(ClasseRequest classeRequest) {
        Classe classe = this.classeMapper.fromClasseRequest(classeRequest);
        Filiere filiere = this.filiereRepo.findByNom(classeRequest.getNom_filiere())
                .orElseThrow(() -> new RessourceNotFoundException("This filiere doesn't exist"));
        classe.setFiliere(filiere);
        Option option = this.optionRepo.findByNom(classeRequest.getNom_option())
                .orElseThrow(()->new RessourceNotFoundException("This option doesn't exist"));
        classe.setOption(option);
        classe.setNom(classeRequest.getNom_classe());
        return this.classeMapper.fromClasse(this.classeRepo.save(classe)) ;
    }


    @Override
    public List<ClasseResponse> getClasse() {
        List<Classe> classe = this.classeRepo.findAll();
        List<ClasseResponse> classeResponses = new ArrayList<>();
        classe.forEach(classe1 -> classeResponses.add(this.classeMapper.fromClasse(classe1)));
        return classeResponses;
    }

    @Override
    public ClasseResponse updateClasse(String nom, ClasseRequest classeRequest) {
        Classe newClasse = this.classeRepo.findByNom(nom).get();
        Classe classe = this.classeMapper.fromClasseRequest(classeRequest);
        newClasse.setNom(classe.getNom());
        newClasse.setFiliere(classe.getFiliere());
        newClasse.setOption(classe.getOption());
        return this.classeMapper.fromClasse(this.classeRepo.saveAndFlush(newClasse));
    }

    @Override
    public void deleteClasse(String nom) {
        Classe classe = this.classeRepo.findByNom(nom).get();
        this.classeRepo.delete(classe);
    }
}
