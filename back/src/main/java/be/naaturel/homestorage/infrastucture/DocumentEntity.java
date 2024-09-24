package be.naaturel.homestorage.infrastucture;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity(name = "documents")
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long token;

    @Column
    public String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "BLOB", nullable = false)
    public byte[] content;

}