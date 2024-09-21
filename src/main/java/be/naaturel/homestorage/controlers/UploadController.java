package be.naaturel.homestorage.controlers;

import be.naaturel.homestorage.configurations.Configurations;
import be.naaturel.homestorage.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    private final Configurations conf;
    private final FileService fileService;

    @Autowired
    public UploadController(Configurations conf) {
        this.conf = conf;
        this.fileService = new FileService();
    }

    @PostMapping("/api/upload")
    public ResponseEntity<String> handleFileUploadUsingCurl(@RequestParam("file") MultipartFile file) {

        try {
            this.fileService.upload(conf.storageLocation, file);
        } catch (IOException ioe) {
            return ResponseEntity.badRequest().body("Unable to save file for reason : " + ioe.getMessage());
        }

        return ResponseEntity.ok("File successfully uploaded");
    }
}
