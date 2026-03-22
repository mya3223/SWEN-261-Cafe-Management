package com.example.swen261cafemanagement.service;

import org.springframework.stereotype.Service;
import com.example.swen261cafemanagement.models.User;

import java.util.ArrayList;

@Service
public class UserService {
        private ArrayList<User> users = new ArrayList<>();

        public void createUser(User user) {
            users.add(user);
        }

        public ArrayList<User> getAllUsers() {
            return users;
        }

        public User findByUserByEmail(String email) {
            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    return user;
                }

            }
            return null;
        }
        public UserService() {
           User test_user = new User("test user","test@gmail.com", "testpassword");
           User test2 = new User("test user2","test@test.com", "password");
           createUser(test_user);
           createUser(test2);
        }

}