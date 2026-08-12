package com.kushagra.restapi.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {
   
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
       return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {

        User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id){
        try {
            userRepository.findById(id).get();
            userRepository.deleteById(id);
            return "User deleted Successfully";
        } catch (Exception e) {
            return "User not Found";
        }
    }
}
