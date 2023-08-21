package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.dto.enseignant_dto.EnseignantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.enseignant_dto.EnseignantResponseDTO;


import java.util.List;

public interface IEnseignantService {
    EnseignantResponseDTO addEnseignant(EnseignantRequestDTO enseignantRequestDTO);
    EnseignantResponseDTO getEnseignant(String email);
    List<EnseignantResponseDTO> getEnseignants();
    EnseignantResponseDTO updateEnseignant(String email,EnseignantRequestDTO enseignantRequestDTO);
    void deleteEnseignant(String email);
}
