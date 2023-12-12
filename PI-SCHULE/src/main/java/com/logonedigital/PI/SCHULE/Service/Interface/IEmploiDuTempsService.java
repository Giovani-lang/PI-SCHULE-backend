package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsResponse;

import java.util.List;

public interface IEmploiDuTempsService {
    EmploiDuTempsResponse addEmploiDuTemps(EmploiDuTempsRequest emploiDuTemps);
    List<EmploiDuTempsResponse> getEmploisDuTemps();
    EmploiDuTempsResponse getEmploiDuTemps(String classe);
    EmploiDuTempsResponse updateEmploiDuTemps(EmploiDuTempsRequest emploiDuTemps, String classe);
    void deleteEmploiDuTemps(String classe);

}
