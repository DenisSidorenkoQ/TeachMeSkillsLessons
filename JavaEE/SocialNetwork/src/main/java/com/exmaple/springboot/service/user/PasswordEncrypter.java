package com.exmaple.springboot.service.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class PasswordEncrypter {
    private final BCrypt.Hasher hasher;

    public PasswordEncrypter(@Value("${salt}") String salt) {
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
