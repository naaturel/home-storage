package be.naaturel.homestorage.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Configurations {

    @Value("${storage.location}")
    public String storageLocation = "";

    @Value("${sec.cors.authorizedHots}")
    public String[] authorizedHosts;

    @Value("${sec.cors.authorizedMethods}")
    public String[] authorizedMethods;

    @Value("${sec.cors.authorizedHeader}")
    public String[] authorizedHeaders;


}
