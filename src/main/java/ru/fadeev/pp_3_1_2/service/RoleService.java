package ru.fadeev.pp_3_1_2.service;

import ru.fadeev.pp_3_1_2.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Long id);

    Role getRoleByName(String name);

    List<Role> getAllRoles();

    void addRole(Role role);
}
