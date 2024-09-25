package be.naaturel.homestorage.models;

import be.naaturel.homestorage.repository.DocumentRepo;
import be.naaturel.homestorage.utils.Encrypter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.File;
import java.nio.file.Path;
import java.security.InvalidKeyException;

public class Document extends File {

    private Path location;

    private String name;

    public Document(Path location, String name){
        super(location.toString());
        this.location = location;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Path getLocation(){return this.location;}


}
