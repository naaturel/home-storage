package be.naaturel.homestorage.repository;

import be.naaturel.homestorage.infrastucture.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo
        extends JpaRepository<UserEntity, Long> {

    public UserEntity findByName(String name);

}
