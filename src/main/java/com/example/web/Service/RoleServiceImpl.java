package com.example.web.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.web.dao.RoleDAO;
import com.example.web.models.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public Role getRoleById(long id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDAO.getRoleByName(roleName);
    }

    @Override
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Override
    public void removeRole(long id) {
        roleDAO.removeRole(id);
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleSet) {
        return roleDAO.getSetOfRoles(roleSet);
    }

    @Override
    public Set<Role> setRoleByName(String name, String[] rolesName) {
        return roleDAO.setRoleByName(name, rolesName);
    }
}
