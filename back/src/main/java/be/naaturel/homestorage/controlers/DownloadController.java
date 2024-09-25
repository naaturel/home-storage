package be.naaturel.homestorage.controlers;

import be.naaturel.homestorage.configurations.Configurations;
import be.naaturel.homestorage.repository.DocumentRepo;
import be.naaturel.homestorage.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

@RestController
public class DownloadController {

    private final Configurations conf;

    private final FileService fileService;

    @Autowired
    public DownloadController(Configurations conf, FileService service) {
        this.conf = conf;
        this.fileService = service;
    }

    @GetMapping("/api/files")
    public ResponseEntity<Set<String> > listFiles(){

        Set<String> files = fileService.list(conf.storageLocation);
        return ResponseEntity.ok(files);
    }

    @GetMapping("api/download/{fileName:.+}")
    public ResponseEntity<?> download(@PathVariable String fileName){

        Path path = Paths.get(conf.storageLocation + fileName);
        Resource resource = null;

        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("multipart/form-data"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
