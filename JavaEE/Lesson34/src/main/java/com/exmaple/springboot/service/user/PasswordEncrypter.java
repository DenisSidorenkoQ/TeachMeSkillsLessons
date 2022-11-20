package com.exmaple.springboot.service.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class PasswordEncrypter {
    @Autowired
    private Environment env;
    private final BCrypt.Hasher hasher;

    public PasswordEncrypter() {
        String salt = env.getProperty("salt");
        hasher = BCrypt.with(new SecureRandom(salt.getBytes()));
    }

    public String getEncryptedPassword(String password) {

        return hasher.hashToString(12, password.toCharArray());
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        final BCrypt.Result verify = BCrypt.verifyer().verify(password.getBytes(), hashedPassword.getBytes());
        return verify.verified;
    }
}
