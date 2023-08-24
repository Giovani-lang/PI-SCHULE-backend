package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Etudiant;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.EtudiantMapper;
import com.logonedigital.PI.SCHULE.Repository.EtudiantRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IEtudiantService;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepository etudiantRepo;
    private final EtudiantMapper etudiantMapper;
    @Override
    public EtudiantResponseDTO addEtudiant(EtudiantRequestDTO etudiantRequestDTO) throws RessourceExistException {
        Optional<Etudiant> etu1 = this.etudiantRepo.findByEmail(etudiantRequestDTO.getEmail());
        Optional<Etudiant> etu2 = this.etudiantRepo.findByTelephone(etudiantRequestDTO.getTelephone());
        Etudiant etu = this.etudiantMapper.fromEtudiantRequestDTO(etudiantRequestDTO);
        if (etu1.isPresent()){
            throw new RessourceExistException("Student with this email already exist !!!");
        } else if (etu2.isPresent()) {
            throw new RessourceExistException("Student with this phone already exist !!!");
        }
        etu.setCreatedAt(new Date());
        return this.etudiantMapper.fromEtudiant(this.etudiantRepo.save(etu));
    }

    @Override
    public EtudiantResponseDTO getEtudiant(String email) throws RessourceNotFoundException {
        try {
            return this.etudiantMapper.fromEtudiant(this.etudiantRepo.findByEmail(email).get());
        }catch (Exception ex){
            throw new RessourceNotFoundException("This email " +email+ " doesn't exist in our data base");
        }
    }

    @Override
    public List<EtudiantResponseDTO> getEtudiants() {
        List<Etudiant> etudiants = this.etudiantRepo.findAll();
        List<EtudiantResponseDTO> etudiantResponses = new ArrayList<>();
        etudiants.forEach(etudiant -> etudiantResponses.add(this.etudiantMapper.fromEtudiant(etudiant)));
        return etudiantResponses;
    }

    @Override
    public EtudiantResponseDTO updateEtudiant(String email, EtudiantRequestDTO etudiantRequestDTO)throws RessourceNotFoundException {
        try {
            Etudiant etu = this.etudiantRepo.findByEmail(email).get();
            etu.setEmail(etudiantRequestDTO.getEmail());
            etu.setNom(etudiantRequestDTO.getNom());
            etu.setPrenom(etudiantRequestDTO.getPrenom());
            etu.setTelephone(etudiantRequestDTO.getTelephone());
            etu.setPassword(etudiantRequestDTO.getPassword());
            etu.setDateNaissance(etudiantRequestDTO.getDateNaissance());
            etu.setFiliere(etudiantRequestDTO.getFiliere());
            etu.setGenre(etudiantRequestDTO.getGenre());
            etu.setOption(etudiantRequestDTO.getOption());
            etu.setNiveau(etudiantRequestDTO.getNiveau());
            return this.etudiantMapper.fromEtudiant(this.etudiantRepo.save(etu));
        }catch (Exception ex){
            throw new RessourceNotFoundException("This email " +email+ " doesn't exist in our data base");
        }
    }

    @Override
    public void deleteEtudiant(String email) throws RessourceNotFoundException{
        Optional<Etudiant> etu = this.etudiantRepo.findByEmail(email);
        this.etudiantRepo.delete(etu.get());
        if (etu.isEmpty()){
            throw new RessourceNotFoundException("This email " +email+ " doesn't exist in our data base");
        }
    }
}
