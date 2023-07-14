package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;

import java.util.List;

public interface EmploiDuTempsService {
    EmploiDuTemps addEmploiDuTemps(EmploiDuTemps emploiDuTemps);
    List<EmploiDuTemps> getEmploisDuTemps();
    EmploiDuTemps getEmploiDuTemps(Integer idClass);
    EmploiDuTemps updateEmploiDuTemps(EmploiDuTemps emploiDuTemps, Integer idClass);
    void deleteEmploiDuTemps(Integer idClass);

}
