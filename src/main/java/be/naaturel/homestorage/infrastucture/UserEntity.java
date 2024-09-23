package be.naaturel.homestorage.infrastucture;

import jakarta.persistence.*;

@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String salt;

}
