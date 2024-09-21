package be.naaturel.homestorage.controlers;

import be.naaturel.homestorage.configurations.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class DownloadController {


    private final Configurations conf;

    @Autowired
    public DownloadController(Configurations conf) {
        this.conf = conf;
    }

    @GetMapping("/api/files")
    public ResponseEntity<Set<String> > listFiles(){

        Set<String> files = Stream.of(new File(conf.savePath).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());

        return ResponseEntity.ok(files);
    }

}
