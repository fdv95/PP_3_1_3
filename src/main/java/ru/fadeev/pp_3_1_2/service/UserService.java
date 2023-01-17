package ru.fadeev.pp_3_1_2.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.fadeev.pp_3_1_2.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getUsersList();

    void addUser(User user);

    User getUserById(long id);

    void updateUser(long id, User updateUser);

    void deleteUser(long id);

    UserDetails loadUserByUsername(String username);
}