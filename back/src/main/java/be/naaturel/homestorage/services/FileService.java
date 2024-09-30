package be.naaturel.homestorage.services;

import be.naaturel.homestorage.exceptions.CriticalException;
import be.naaturel.homestorage.exceptions.FileSaveException;
import be.naaturel.homestorage.mapping.DocumentMapper;
import be.naaturel.homestorage.models.Document;
import be.naaturel.homestorage.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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

    public void upload(String location, MultipartFile file) throws FileSaveException, CriticalException {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Path path = Path.of(location, fileName);

        Document doc = new Document(path, fileName);

        try {

            file.transferTo(doc.getLocation());
            repo.save(DocumentMapper.toEntity(doc));

        } catch (IOException | IllegalStateException e) {
            /*If the file system save has failed*/

            throw new FileSaveException("Unable to save the document within the file system");

        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            /*If the database save has failed but file system save has succeeded*/
            /*We want to keep database and file system synchronized*/

            if(doc.exists() && !doc.delete())
                throw new CriticalException("What the heck just happened. It shouldn't even be possible");

            throw new FileSaveException("Unable to reference the document in the database");
        }

    }

    public void download() {

    }

    public void encrypt() {

    }

    public void decrypt() {

    }

}
