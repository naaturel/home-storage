package be.naaturel.homestorage.controlers;

import be.naaturel.homestorage.configurations.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    public UploadController(Configurations conf) {
        this.conf = conf;
    }

    @PostMapping("/api/upload")
    public ResponseEntity<Map<String, String>> handleFileUploadUsingCurl(
            @RequestParam("file") MultipartFile file) throws IOException {

        Map<String, String> map = new HashMap<>();

        // Populate the map with file details
        map.put("fileName", file.getOriginalFilename());
        map.put("fileSize", String.valueOf(file.getSize()));
        map.put("fileContentType", file.getContentType());

        // File upload is successful
        map.put("message", "File upload done");

        String path = String.format("%s%s", conf.savePath, file.getOriginalFilename());
        file.transferTo(new File(path));

        return ResponseEntity.ok(map);
    }
}
