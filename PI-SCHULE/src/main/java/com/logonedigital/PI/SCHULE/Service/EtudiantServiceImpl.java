package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.*;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.EtudiantMapper;
import com.logonedigital.PI.SCHULE.Repository.EtudiantRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IEtudiantService;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder encoder;
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

        List<Note> note = this.etudiantMapper.fromNoteRequest(etudiantRequestDTO.getNoteRequestList());
        etu.setNotes(note);
        List<FicheDePresence> ficheDePresences = this.etudiantMapper.fromFicheDePresenceRequest(etudiantRequestDTO.getFiches());
        etu.setFicheDePresence(ficheDePresences);
        List<PensionScolaire> pensionScolaireList = this.etudiantMapper.fromPensionRequest(etudiantRequestDTO.getPensions());
        etu.setPensionScolaires(pensionScolaireList);
        EmploiDuTemps emploiDuTemps = this.etudiantMapper.fromEmploiDuTempsRequest(etudiantRequestDTO.getEmploisDuTemps());
        etu.setEmploiDuTemps(emploiDuTemps);
        etu.setRole("ETUDIANT");
        etu.setPassword(this.encoder.encode(etu.getPassword()));
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
            Etudiant etudiant = this.etudiantMapper.fromEtudiantRequestDTO(etudiantRequestDTO);
            etu.setEmail(etudiant.getEmail());
            etu.setNom(etudiant.getNom());
            etu.setPrenom(etudiant.getPrenom());
            etu.setTelephone(etudiant.getTelephone());
            etu.setPassword(etudiant.getPassword());
            etu.setDateNaissance(etudiant.getDateNaissance());
            etu.setFiliere(etudiant.getFiliere());
            etu.setGenre(etudiant.getGenre());
            etu.setOption(etudiant.getOption());
            etu.setNiveau(etudiant.getNiveau());
            etu.setUpdatedAt(new Date());
            etu.setNotes(etudiant.getNotes());
            etu.setPensionScolaires(etudiant.getPensionScolaires());
            etu.setFicheDePresence(etudiant.getFicheDePresence());
            etu.setEmploiDuTemps(etudiant.getEmploiDuTemps());
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
