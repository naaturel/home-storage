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
    private final PasswordHasher pwdHasher;

    @Autowired
    public UserService(UserRepo userRepo){

        this.userRepo = userRepo;
        this.pwdHasher = new PasswordHasher();
    }

    public void register(User u){
        UserEntity ue = UserMapper.toEntity(u);
        ue.password = pwdHasher.hash(ue.password);
        userRepo.save(ue);
    }

    public boolean authenticate(User u){

        UserEntity entity = userRepo.findByName(u.getName());
        if(entity == null) return false;

        return pwdHasher.check(u.getPassword(), entity.password);
    }

}
