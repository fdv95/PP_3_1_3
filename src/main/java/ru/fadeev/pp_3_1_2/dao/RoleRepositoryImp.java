package ru.fadeev.pp_3_1_2.dao;

import org.springframework.stereotype.Repository;
import ru.fadeev.pp_3_1_2.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleRepositoryImp implements RoleRepository{
    @PersistenceContext
    private final EntityManager entityManager;

    public RoleRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r ", Role.class)
                .getResultList();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.find(Role.class, name);
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }
}
