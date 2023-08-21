package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Role;
import com.logonedigital.PI.SCHULE.Repository.RoleRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final RoleRepository roleRepo;
    @Override
    public Role addRole(Role role) {
        return this.roleRepo.save(role);
    }

    @Override
    public Role getRole(Integer id) {
        return this.roleRepo.findById(id).get();
    }

    @Override
    public List<Role> getRoles() {
        return this.roleRepo.findAll();
    }

    @Override
    public Role updateRle(Integer id, Role role) {
        Role newRole = this.roleRepo.findById(id).get();
        newRole.setRoleName(role.getRoleName());
        return this.roleRepo.save(newRole);
    }

    @Override
    public void deleteRole(Integer id) {
        this.roleRepo.deleteById(id);
    }
}
