package be.naaturel.homestorage.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {


    public Set<String> list(String location) {
        return Stream.of(Objects.requireNonNull(new File(location).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public void upload(String location, MultipartFile file) throws IOException {
        String path = String.format("%s%s", location, file.getOriginalFilename());
        file.transferTo(new File(path));
    }

    public void download() {

    }

    public void encrypt() {

    }

    public void decrypt() {

    }

}
