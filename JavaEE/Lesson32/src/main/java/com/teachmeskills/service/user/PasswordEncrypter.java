package com.teachmeskills.service.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.RequiredArgsConstructor;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RequiredArgsConstructor
public class PasswordEncrypter {
    private final BCrypt.Hasher hasher;

    public String getEncryptedPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        final String hashedPassword = hasher.hashToString(12, password.toCharArray());

        return hashedPassword;
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        final BCrypt.Result verify = BCrypt.verifyer().verify(password.getBytes(), hashedPassword.getBytes());
        return verify.verified;
    }
}
