package be.naaturel.homestorage.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Configurations {

    @Value("${storage.location}")
    public String storageLocation = "";

}
