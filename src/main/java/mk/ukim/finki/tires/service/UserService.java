package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.User;

import java.util.List;

/**
 * Created by user on 31.5.2017.
 */
public interface UserService {

    List<User> findAll();
    User findById(Long id);
    void insert(User entity);
    void update(Long id,User entity);
    void deleteById(Long id);
}
