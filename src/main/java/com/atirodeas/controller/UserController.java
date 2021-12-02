package com.atirodeas.controller;

import com.atirodeas.entities.UserEntity;
import com.atirodeas.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", 
             methods = {RequestMethod.GET,
                        RequestMethod.POST,
                        RequestMethod.PUT,
                        RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;
    
    /**
     *
     * @return
     */
    @GetMapping("/all")
    public List<UserEntity> getAll() {
        return userService.getAll();
    }
    
    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity registrar(@RequestBody UserEntity user) {
        return userService.registrar(user);
    }
    
    /**
     *
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public UserEntity autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    
    /**
     *
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }   
}

