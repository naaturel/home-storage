package be.naaturel.homestorage.controlers;

import be.naaturel.homestorage.configurations.Configurations;
import be.naaturel.homestorage.exceptions.CriticalException;
import be.naaturel.homestorage.exceptions.FileSaveException;
import be.naaturel.homestorage.repository.DocumentRepo;
import be.naaturel.homestorage.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    private final Configurations conf;
    private final FileService fileService;

    @Autowired
    public UploadController(Configurations conf, FileService service) {
        this.conf = conf;
        this.fileService = service;
    }

    @PostMapping("/api/upload")
    public ResponseEntity<String> handleFileUploadUsingCurl(@RequestParam("file") MultipartFile file) {

        try {
            this.fileService.upload(conf.storageLocation, file);
        } catch (FileSaveException | CriticalException fse) {
            return ResponseEntity.badRequest().body("Unable to save file for reason : " + fse.getMessage());
        }

        return ResponseEntity.ok("File successfully uploaded");
    }
}
