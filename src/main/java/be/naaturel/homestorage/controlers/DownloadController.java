package be.naaturel.homestorage.controlers;

import be.naaturel.homestorage.configurations.Configurations;
import be.naaturel.homestorage.repository.DocumentRepo;
import be.naaturel.homestorage.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
