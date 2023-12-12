package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Lemploi;
import com.logonedigital.PI.SCHULE.dto.lemploi_dto.LemploiRequest;
import com.logonedigital.PI.SCHULE.dto.lemploi_dto.LemploiResponse;

import java.util.List;

public interface ILemploiService {
    LemploiResponse addLemploi(LemploiRequest lemploi);
    List<LemploiResponse> findAllLemploiByClasse(String classe);
//    List<LemploiResponse> getAllLemploi();
    LemploiResponse updateLemploi(Long id, LemploiRequest lemploi);
    void deleteLemploi (Long id);
}
