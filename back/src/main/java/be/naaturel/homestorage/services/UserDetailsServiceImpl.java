package be.naaturel.homestorage.services;

import be.naaturel.homestorage.infrastucture.UserEntity;
import be.naaturel.homestorage.mapping.UserMapper;
import be.naaturel.homestorage.models.User;
import be.naaturel.homestorage.repository.UserRepo;
import be.naaturel.homestorage.utils.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordHasher pwdHasher;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo){

        this.userRepo = userRepo;
        this.pwdHasher = new PasswordHasher();
    }

    public void register(User u){
        UserEntity ue = UserMapper.toEntity(u);
        ue.setPassword(pwdHasher.hash(ue.getPassword()));
        userRepo.save(ue);
    }

    public boolean authenticate(User u){

        UserDetails ud;
        try{
            ud = loadUserByUsername(u.getName());
        } catch (UsernameNotFoundException unfe){
            return false;
        }

        return pwdHasher.check(u.getPassword(), ud.getPassword());

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByName(username);
        if (user == null) throw new UsernameNotFoundException("User not found");

        return user;
    }
}
