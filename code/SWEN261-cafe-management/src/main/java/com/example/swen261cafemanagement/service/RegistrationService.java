package com.example.swen261cafemanagement.service;

import com.example.swen261cafemanagement.models.User;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.regex.Pattern;

@Service
public class RegistrationService {
    private final UserService userService;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    private String hash(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(pass.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) { sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3)); }
            return sb.toString();
        } catch (Exception e) { return pass; }
    }
    public String validateAndRegister(String name, String email, String pass, String confirm) {
        if (!Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email).find()) {
            return "Email format is invalid.";
        }
        if (!pass.equals(confirm)) {
            return "Passwords do not match.";
        }
        if (userService.findByUserByEmail(email) != null) {
            return "This email is already in use.";
        }

        String hashed = hash(pass);

        User newUser = new User(name, email, hashed, "OWNER");
        userService.createUser(newUser);

        return null;
    }

}
