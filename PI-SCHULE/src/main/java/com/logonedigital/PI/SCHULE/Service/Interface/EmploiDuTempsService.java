package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsResponse;

import java.util.List;

public interface EmploiDuTempsService {
    EmploiDuTempsResponse addEmploiDuTemps(EmploiDuTempsRequest emploiDuTemps);
    List<EmploiDuTempsResponse> getEmploisDuTemps();
    EmploiDuTempsResponse getEmploiDuTemps(Integer idClass);
    EmploiDuTempsResponse updateEmploiDuTemps(EmploiDuTempsRequest emploiDuTemps, Integer idClass);
    void deleteEmploiDuTemps(Integer idClass);

}
