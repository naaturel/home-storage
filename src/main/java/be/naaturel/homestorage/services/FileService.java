package be.naaturel.homestorage.services;

import be.naaturel.homestorage.Mapping.DocumentMapper;
import be.naaturel.homestorage.models.Document;
import be.naaturel.homestorage.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileService {

    private final DocumentRepo repo;

    @Autowired
    public FileService(DocumentRepo repo){
        this.repo = repo;
    }

    public Set<String> list(String location) {
        return Stream.of(Objects.requireNonNull(new File(location).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public void upload(String location, MultipartFile file) throws IOException {
        Document doc = new Document();
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        doc.setName(fileName);
        doc.setContent(file.getBytes());

        repo.save(DocumentMapper.toEntity(doc));

    }

    public void download() {

    }

    public void encrypt() {

    }

    public void decrypt() {

    }

}
