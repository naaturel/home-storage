package be.naaturel.homestorage.infrastucture;

import jakarta.persistence.*;

@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column
    public String name;

    @Column
    public String password;

    @Column
    public String salt;

}
