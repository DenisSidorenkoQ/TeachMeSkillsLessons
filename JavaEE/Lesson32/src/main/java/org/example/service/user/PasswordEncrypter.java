package org.example.service.user;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;


public class PasswordEncrypter {
    private final BCrypt.Hasher hasher;

    public PasswordEncrypter(byte[] salt) {
        hasher = BCrypt.with(new SecureRandom(salt));
    }

    public String getEncryptedPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        final String hashedPassword = hasher.hashToString(12, password.toCharArray());

        return hashedPassword;
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        final BCrypt.Result verify = BCrypt.verifyer().verify(password.getBytes(), hashedPassword.getBytes());
        return verify.verified;
    }
}
