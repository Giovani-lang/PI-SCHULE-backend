package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementRequest;
import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementResponse;

import java.util.List;

public interface IPaiementService {
    PaiementResponse addPaiement (PaiementRequest paiementRequest);
    List<PaiementResponse> getPaiement (String matricule);
//    List<PaiementResponse> getAllPaiement();
    PaiementResponse editPaiement (Long id, PaiementRequest paiementRequest);
    void deletePaiement (Long id);
}
