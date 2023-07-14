package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Releve;

import java.util.List;

public interface IReleveService {

    Releve addModule(Releve releve);
    Releve getModule(String module);
    List<Releve> getModule();
    Releve updateModule(String module,Releve releve);
    void deleteModule(String module);

}