package com.atirodeas.repository;

import com.atirodeas.entities.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<UserEntity> getAll() {
        return (List<UserEntity>) userCrudRepository.findAll();
    }

    public Optional<UserEntity> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public UserEntity save(UserEntity user) {
        return userCrudRepository.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<UserEntity> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<UserEntity> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
