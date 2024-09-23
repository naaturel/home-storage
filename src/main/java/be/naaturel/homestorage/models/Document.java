package be.naaturel.homestorage.models;

import be.naaturel.homestorage.repository.DocumentRepo;
import be.naaturel.homestorage.utils.Encrypter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public class Document {

    private Long token;

    private String name;

    private byte[] content;

    private Encrypter encrypter;

    public Document(){
        encrypter = new Encrypter();
    }

    public Long getToken(){
        return this.token;
    }

    public String getName(){
        return this.name;
    }
    public byte[] getContent(){
        return this.content;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setContent(byte[] content){
        try {
            this.content = encrypter.encrypt(content);
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
