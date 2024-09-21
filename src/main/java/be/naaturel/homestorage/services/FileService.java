package be.naaturel.homestorage.services;

import be.naaturel.homestorage.utils.Encrypter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

    private final Encrypter encrypter;

    public FileService(){
        this.encrypter = new Encrypter();
    }

    public Set<String> list(String location) {
        return Stream.of(Objects.requireNonNull(new File(location).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public void upload(String saveLocation, MultipartFile file) throws IOException {
        String path = String.format("%s%s", saveLocation, file.getOriginalFilename());

        try {
            encrypter.encrypt(file.getBytes(), path);
        } catch (InvalidKeyException ike){
            throw new RuntimeException(ike.getMessage());
        }

    }

    public void download() {

    }
}
