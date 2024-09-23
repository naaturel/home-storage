package be.naaturel.homestorage.services;

import be.naaturel.homestorage.infrastucture.UserEntity;
import be.naaturel.homestorage.mapping.UserMapper;
import be.naaturel.homestorage.models.User;
import be.naaturel.homestorage.repository.UserRepo;
import be.naaturel.homestorage.utils.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void register(User u){
        u.hashPassword();
        UserEntity ue = UserMapper.toEntity(u);
        userRepo.save(ue);
    }
}
