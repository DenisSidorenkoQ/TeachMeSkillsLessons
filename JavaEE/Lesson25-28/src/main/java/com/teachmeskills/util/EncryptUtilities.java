package com.teachmeskills.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class EncryptUtilities {
    final String algorithm = "PBKDF2WithHmacSHA1";
    final int keyLength = 160;
    final int iterations = 1000;
    byte[] salt;

    public EncryptUtilities(byte[] salt) {
        this.salt = salt;
    }

    public String getEncryptedPassword(
            String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
        SecretKeyFactory secretKey = SecretKeyFactory.getInstance(algorithm);

        byte[] encryptedPasswordBytes = secretKey.generateSecret(spec).getEncoded();
        StringBuilder encryptedPasswordString = new StringBuilder();

        for (byte encryptedPasswordByte : encryptedPasswordBytes) {
            encryptedPasswordString.append(Byte.toString(encryptedPasswordByte));
        }

        return encryptedPasswordString.toString();
    }
}
