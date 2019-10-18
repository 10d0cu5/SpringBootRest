package com.demo.restapi;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController //Responses from each method will be written in body of response instead of rendering a template
public class UserController {

    private final UserRepository repository; //Injected into the constructor


    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    //Aggregate Root
    @GetMapping("/users")
    List<User> all(){
        return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser){
        return repository.save(newUser);
    }

    //Single Items
    @GetMapping("/users/{id}")
    User one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    
    @PutMapping("/users/{id}")
    User replaceeUser(@RequestBody User newUser, @PathVariable Long id){
        
        return repository.findById(id)
                .map(user -> {
                    user.setPrename(newUser.getPrename());
                    user.setLastname(newUser.getLastname());
                    user.setEmail(newUser.getEmail());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id){
        repository.deleteById(id);
    }


}
