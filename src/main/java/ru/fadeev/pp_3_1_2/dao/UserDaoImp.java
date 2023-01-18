package ru.fadeev.pp_3_1_2.dao;


import org.springframework.stereotype.Repository;
import ru.fadeev.pp_3_1_2.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsersList() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(long id, User updateUser) {
        //updateUser - значения из формы edit, userToBeUpdate - значения из БД
//        User userToBeUpdate = getUserById(id);
//        userToBeUpdate.setName(updateUser.getName());
//        userToBeUpdate.setLastName(updateUser.getLastName());
//        userToBeUpdate.setAge(updateUser.getAge());
//        userToBeUpdate.setUsername(updateUser.getUsername());
//        userToBeUpdate.setPassword(updateUser.getPassword());
        entityManager.merge(updateUser);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username", User.class)
                .setParameter("username", username);
        return query.getSingleResult();
    }
}
