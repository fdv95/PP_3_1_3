package ru.fadeev.pp_3_1_2.service;


import ru.fadeev.pp_3_1_2.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();

    void addUser(User user);

    User getUserById(int id);

    void updateUser(int id, User updateUser);

    void deleteUser(int id);
}
