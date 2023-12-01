package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.*;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.EtudiantMapper;
import com.logonedigital.PI.SCHULE.Repository.AnneeAcademiqueRepository;
import com.logonedigital.PI.SCHULE.Repository.EtudiantRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IEtudiantService;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepository etudiantRepo;
    private final EtudiantMapper etudiantMapper;
    private final PasswordEncoder encoder;
    private final AnneeAcademiqueRepository anneeAcademiqueRepo;


    public String generateMatricule(){
        String prefix = "SCHULE";
        String suffix = String.format("%03d", new Random().nextInt(1000));
        return  prefix + suffix;
    }

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
        AnneeAcademique anneeAcademique = this.anneeAcademiqueRepo.findByAnnees(etudiantRequestDTO.getAnnee_academique())
                .orElseThrow(()-> new RessourceNotFoundException("Impossible year "+etudiantRequestDTO.getAnnee_academique()+" doesn't exist, try again !"));
        etu.setMatricule(generateMatricule());
        etu.setAnneeAcademique(anneeAcademique);
        etu.setCreatedAt(new Date());
        etu.setRole("ETUDIANT");
        etu.setPassword(this.encoder.encode(etu.getPassword()));
        return this.etudiantMapper.fromEtudiant(this.etudiantRepo.save(etu));
    }

    @Override
    public EtudiantResponseDTO getEtudiant(String matricule) throws RessourceNotFoundException {
        try {
            return this.etudiantMapper.fromEtudiant(this.etudiantRepo.findByMatricule(matricule).get());
        }catch (Exception ex){
            throw new RessourceNotFoundException("This email " +matricule+ " doesn't exist in our data base");
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
    public EtudiantResponseDTO updateEtudiant(String matricule, EtudiantRequestDTO etudiantRequestDTO)throws RessourceNotFoundException {
        try {
            Etudiant etu = this.etudiantRepo.findByMatricule(matricule).get();
            Etudiant etudiant = this.etudiantMapper.fromEtudiantRequestDTO(etudiantRequestDTO);
            etu.setEmail(etudiant.getEmail());
            etu.setImage_url(etudiant.getImage_url());
            etu.setNom(etudiant.getNom());
            etu.setPrenom(etudiant.getPrenom());
            etu.setTelephone(etudiant.getTelephone());
            etu.setPassword(etudiant.getPassword());
            etu.setDateNaissance(etudiant.getDateNaissance());
            etu.setFiliere(etudiant.getFiliere());
            etu.setGenre(etudiant.getGenre());
            etu.setOption(etudiant.getOption());
            etu.setNiveau(etudiant.getNiveau());
            etu.setDateInscription(etudiant.getDateInscription());
            etu.setUpdatedAt(new Date());
            return this.etudiantMapper.fromEtudiant(this.etudiantRepo.save(etu));
        }catch (Exception ex){
            throw new RessourceNotFoundException("This email " +matricule+ " doesn't exist in our data base");
        }
    }

    @Override
    public void deleteEtudiant(String matricule) throws RessourceNotFoundException{
        Optional<Etudiant> etu = this.etudiantRepo.findByMatricule(matricule);
        this.etudiantRepo.delete(etu.get());
        if (etu.isEmpty()){
            throw new RessourceNotFoundException("This email " +matricule+ " doesn't exist in our data base");
        }
    }
}
