package be.naaturel.homestorage.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public abstract class Cryptography {

    protected final SecretKey secretKey;
    protected final Cipher cipher;

    public Cryptography() {
        try{
            this.secretKey = KeyGenerator.getInstance("AES").generateKey();
            this.cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        } catch (NoSuchAlgorithmException | NoSuchPaddingException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
