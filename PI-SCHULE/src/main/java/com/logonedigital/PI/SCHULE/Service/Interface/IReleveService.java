package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Entity.Releve;
import com.logonedigital.PI.SCHULE.dto.releve_dto.ReleveRequest;
import com.logonedigital.PI.SCHULE.dto.releve_dto.ReleveResponse;

import java.util.List;

public interface IReleveService {
    ReleveResponse addModule(ReleveRequest module);
    ReleveResponse getModule(String module);
    List<ReleveResponse> getModule();
   ReleveResponse updateModule(String module,ReleveRequest releve);
    void deleteModule(String module);

}
