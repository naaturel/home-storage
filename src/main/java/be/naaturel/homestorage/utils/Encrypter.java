package be.naaturel.homestorage.utils;

import javax.crypto.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encrypter extends Cryptography {

    public Encrypter() { super(); }

    public byte[] encrypt(byte[] bytes) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] iv = cipher.getIV();

        return cipher.doFinal(bytes);
    }
}
