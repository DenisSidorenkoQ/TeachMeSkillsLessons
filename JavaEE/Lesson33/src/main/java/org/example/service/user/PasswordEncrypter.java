package org.example.service.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class PasswordEncrypter {
    private final BCrypt.Hasher hasher;

    public PasswordEncrypter(@Value("${salt}") final String salt) {
        hasher = BCrypt.with(new SecureRandom(salt.getBytes()));
    }

    public String getEncryptedPassword(String password) {
        final String hashedPassword = hasher.hashToString(12, password.toCharArray());

        return hashedPassword;
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        final BCrypt.Result verify = BCrypt.verifyer().verify(password.getBytes(), hashedPassword.getBytes());
        return verify.verified;
    }
}
