package com.example.web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.web.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(long id) {
        return (Role) entityManager.createQuery("from Role r where r.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Role getRoleByName(String roleName) {

        return (Role) entityManager.createQuery("from Role r where r.role=:role")
                .setParameter("role", roleName)
                .getSingleResult();
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void removeRole(long id) {
        entityManager.remove(getRoleById(id));
    }

    public HashSet getSetOfRoles(String[] rolesNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : rolesNames) {
            roleSet.add(getRoleByName(role));
        }
        return (HashSet) roleSet;
    }

    public Set<Role> setRoleByName(String name, String[] rolesName) {
        Set<Role> roleSet = new HashSet<Role>();
        if (rolesName != null) {
            for (String roleName : rolesName) {
                roleSet.add(getRoleByName(roleName));
            }
        }
        return roleSet;
    }
}
