package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Administration;

import java.util.List;

public interface AdminService {
    Administration addAdministration(Administration administration);
    List<Administration> getAdministrations();
    Administration getAdministration(String email);
Administration updateAdministration(Administration administration, String email);
void deleteAdministration(String email);

}
