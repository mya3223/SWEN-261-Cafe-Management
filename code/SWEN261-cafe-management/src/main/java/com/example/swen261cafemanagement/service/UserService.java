package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.User;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.ArrayList;

@Service
public class UserService {
        private ArrayList<User> users = new ArrayList<>();
        private String hash(String pass) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] array = md.digest(pass.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : array) { sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3)); }
                return sb.toString();
            } catch (Exception e) { return pass; }
        }
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

        public boolean authenticate(String email, String password) {
            User user = findByUserByEmail(email);
            if (user == null) {
                return false;
            }
            String hashedInputPassword = hash(password);
            return hashedInputPassword.equals(user.getPassword());
        }

        public UserService() {
           User test_user = new User("test user","test@gmail.com", hash("testpassword"));
           User test2 = new User("test user2","test@test.com", hash("password"));
           createUser(test_user);
           createUser(test2);

           User owner = new User("Owner User", "owner@gmail.com", hash("owner123"), "OWNER");
           User staff = new User("Staff User", "staff@gmail.com", hash("staff123"), "STAFF");
           createUser(owner);
           createUser(staff);
        }

        public String createStaff(String name, String email, String password, String role) {

            if (findByUserByEmail(email) != null) {
                return "Email already exists.";
            }

            if (!role.equals("STAFF") && !role.equals("MANAGER")) {
                return "Invalid role.";
            }

            User staff = new User(name, email, hash(password), role);
            createUser(staff);

            return null;
        }


}
