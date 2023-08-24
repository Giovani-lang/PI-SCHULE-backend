package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantResponseDTO;

import java.util.List;

public interface IEtudiantService {
    EtudiantResponseDTO addEtudiant(EtudiantRequestDTO etudiantRequestDTO);
    EtudiantResponseDTO getEtudiant(String email);
    List<EtudiantResponseDTO> getEtudiants();
    EtudiantResponseDTO updateEtudiant(String email, EtudiantRequestDTO etudiantRequestDTO);
    void deleteEtudiant(String email);
}
