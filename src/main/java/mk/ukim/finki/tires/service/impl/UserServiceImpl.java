package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.User;
import mk.ukim.finki.tires.persistence.UserRepository;
import org.springframework.stereotype.Service;
import mk.ukim.finki.tires.service.UserService;

import java.util.List;

/**
 * Created by user on 31.5.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void insert(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void update(Long id, User entity) {
        userRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }
}
