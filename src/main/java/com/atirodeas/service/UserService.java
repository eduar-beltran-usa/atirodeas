package com.atirodeas.service;

import com.atirodeas.entities.UserEntity;
import com.atirodeas.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<UserEntity> getAll() {
        return userRepository.getAll();
    }

    public Optional<UserEntity> getUser(int id) {
        return userRepository.getUser(id);
    }

    public UserEntity registrar(UserEntity user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public UserEntity autenticarUsuario(String email, String password) {
        Optional<UserEntity> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new UserEntity(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}

