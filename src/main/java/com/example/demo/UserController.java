package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

        userRepository.deleteAll();
        User gabrielle = new User("Gabrielle", "Dubois");
        userRepository.save(gabrielle);
        User adrien = new User("Adrien", "Dubois");
        userRepository.save(adrien);
        User alice = new User("Alice", "Dubois");
        userRepository.save(alice);
        User benjamin = new User("Benjamin", "Dubois");
        userRepository.save(benjamin);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List result = new ArrayList<User>();
        userRepository.findAll().forEach(result::add);
        return result;
    }
}
