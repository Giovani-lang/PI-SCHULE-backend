package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.EnseignantMapper;
import com.logonedigital.PI.SCHULE.Repository.EnseignantRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IEnseignantService;
import com.logonedigital.PI.SCHULE.dto.enseignant_dto.EnseignantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.enseignant_dto.EnseignantResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnseignantServiceImpl implements IEnseignantService {

    private final EnseignantRepository enseignantRepo;
    private final EnseignantMapper enseignantMapper;


    @Override
    public EnseignantResponseDTO addEnseignant(EnseignantRequestDTO enseignantRequestDTO) throws RessourceExistException {
        Enseignant ens = this.enseignantMapper.fromEnseignantRequestDTO(enseignantRequestDTO);
        Optional<Enseignant> ens1 = this.enseignantRepo.findByEmail(enseignantRequestDTO.getEmail());
        Optional<Enseignant> ens2 = this.enseignantRepo.findByNumeroTel(enseignantRequestDTO.getNumeroTel());
        if (ens1.isPresent()){
            throw new RessourceExistException("User with this email already exist !");
        } else if (ens2.isPresent()) {
            throw new RessourceExistException("User with this phone already exist !");
        }
        ens.setCreatedAt(new Date());
        return this.enseignantMapper.fromEnseignant(this.enseignantRepo.save(ens));
    }

    @Override
    public EnseignantResponseDTO getEnseignant(String email) throws RessourceNotFoundException {
        try {
            return this.enseignantMapper.fromEnseignant(this.enseignantRepo.findById(email).get());
        }catch (Exception ex){
            throw new RessourceNotFoundException("this email : " +email+" doesn't exist in our data base");
        }
    }

    @Override
    public List<EnseignantResponseDTO> getEnseignants() {
        List<Enseignant> enseignant = this.enseignantRepo.findAll();
        List<EnseignantResponseDTO> enseignantResponses = new ArrayList<>();
        enseignant.forEach(ens ->enseignantResponses.add(this.enseignantMapper.fromEnseignant(ens)));
        return enseignantResponses;
    }

    @Override
    public EnseignantResponseDTO updateEnseignant(String email, EnseignantRequestDTO enseignantRequestDTO) throws RessourceNotFoundException {
        try {
            Enseignant newEnseignant = this.enseignantRepo.findById(email).get();
            newEnseignant.setEmail(enseignantRequestDTO.getEmail());
            newEnseignant.setNom(enseignantRequestDTO.getNom());
            newEnseignant.setPrenom(enseignantRequestDTO.getPrenom());
            newEnseignant.setNumeroTel(enseignantRequestDTO.getNumeroTel());
            newEnseignant.setMotDePasse(enseignantRequestDTO.getMotDePasse());
            newEnseignant.setDiscipline(enseignantRequestDTO.getDiscipline());
            return this.enseignantMapper.fromEnseignant(this.enseignantRepo.save(newEnseignant));
        }catch (Exception ex){
            throw new RessourceNotFoundException("this email : " +email+" doesn't exist in our data base");
        }
    }

    @Override
    public void deleteEnseignant(String email) throws RessourceNotFoundException {
            try {
                Enseignant enseignant = this.enseignantRepo.findByEmail(email).get();
                this.enseignantRepo.delete(enseignant);
            }catch (Exception ex){
                throw new RessourceNotFoundException("this email : " +email+" doesn't exist in our data base");
            }
    }
}
