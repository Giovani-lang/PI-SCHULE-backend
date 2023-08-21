package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Role;

import java.util.List;

public interface IRoleService {
    Role addRole (Role role);
    Role getRole(Integer id);
    List<Role> getRoles();
    Role updateRle (Integer id, Role role);
    void deleteRole (Integer id);
}
