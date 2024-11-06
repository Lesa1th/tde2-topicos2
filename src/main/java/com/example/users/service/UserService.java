package com.example.users.service;

import com.example.users.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "José", 23, "jose@gmail.com");
        User user2 = new User(2, "Joao", 23, "joao@gmail.com");
        User user3 = new User(3, "Joyce", 23, "joyce@gmail.com");
        User user4 = new User(4, "Luis", 25, "luis@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public Optional<User> getUserById(Integer id) {
        Optional<User> optional = Optional.empty();

        for(User user: userList) {
            if(id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }

        return optional;
    }

    public Optional<List<User>> getAllUsers() {
        Optional<List<User>> optional = Optional.empty();

        optional = Optional.of(userList);
        return optional;

    }



    public Optional<User> createUser(String name, int age, String email) {
        Optional <User> optional = Optional.empty();

        int id = (userList.getLast()).getId() + 1;
        User newUser = new User(id, name, age, email);
        userList.add(newUser);

        optional = Optional.of(newUser);

        return optional;
    }

    public Optional<User> editUser(User user) {
        Optional <User> optional = Optional.empty();

        int index=0;
        for(User currentUser: userList) {
            if(user.getId() == currentUser.getId()) {
                optional = Optional.of(user);
                userList.set(index, user);
                return optional;
            }
            index++;
        }
        return optional;
    }

    public void deleteUser(int id) {
        userList.removeIf(user -> (user.getId() == id));
    }
}