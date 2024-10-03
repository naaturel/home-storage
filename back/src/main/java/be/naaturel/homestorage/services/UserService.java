package be.naaturel.homestorage.services;

import be.naaturel.homestorage.exceptions.AuthenticationException;
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
        ue.setPassword(pwdHasher.hash(ue.getPassword()));
        userRepo.save(ue);
    }

    public User authenticate(User u) throws AuthenticationException {

        UserEntity ue = userRepo.findByName(u.getName());

        if (ue == null) throw new AuthenticationException("User not found");
        if(!pwdHasher.check(u.getPassword(), ue.getPassword()))
            throw new AuthenticationException("Incorrect password");

        return UserMapper.toUser(ue);

    }
}
