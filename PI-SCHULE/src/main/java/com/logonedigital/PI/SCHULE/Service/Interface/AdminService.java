package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Administration;

import java.util.List;

public interface AdminService {
    Administration addAdministration(Administration administration);
    List<Administration> getAdministrations();
    Administration getAdministration(Integer id);
Administration updateAdministration(Administration administration, Integer id);
void deleteAdministration(Integer id);

}
