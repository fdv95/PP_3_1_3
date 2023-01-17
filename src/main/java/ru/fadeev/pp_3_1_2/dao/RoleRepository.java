package ru.fadeev.pp_3_1_2.dao;


import ru.fadeev.pp_3_1_2.model.Role;

import java.util.List;

public interface RoleRepository {
    Role getRoleById(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
    void addRole(Role role);
}
