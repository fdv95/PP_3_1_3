package ru.fadeev.pp_3_1_2.dao;


import ru.fadeev.pp_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsersList();

    void addUser(User user);

    User getUserById(int id);

    void updateUser(int id, User updateUser);

    void deleteUser(int id);
}
