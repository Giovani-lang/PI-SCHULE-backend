package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;

import java.util.List;

public interface EmploiDuTempsService {
    EmploiDuTemps addEmploiDuTemps(EmploiDuTempsRequest emploiDuTemps);
    List<EmploiDuTemps> getEmploisDuTemps();
    EmploiDuTemps getEmploiDuTemps(Integer idClass);
    EmploiDuTemps updateEmploiDuTemps(EmploiDuTempsRequest emploiDuTemps, Integer idClass);
    void deleteEmploiDuTemps(Integer idClass);

}
