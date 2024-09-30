package be.naaturel.homestorage.infrastucture;


import jakarta.persistence.*;
import java.util.UUID;

@Entity(name = "documents")
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String token;

    @Column
    public String name;

    @Column
    public String location;

}