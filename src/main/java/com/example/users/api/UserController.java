package com.example.users.api;

import com.example.users.model.User;
import com.example.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUserById(id);

        return  (User) user.orElse(null);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        Optional<List<User>> user = userService.getAllUsers();

        return  (List<User>) user.orElse(null);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        Optional<User> newuser =
                userService.createUser(user.getName(),
                        user.getAge(), user.getEmail());

        return (User) newuser.orElse(null);
    }

    @PutMapping("/user")
    public User editUser(@RequestBody User user) {

        Optional<User> editedUser =
                userService.editUser(user);

        return (User) editedUser.orElse(null);
    }

    @DeleteMapping("/user")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
    }

}