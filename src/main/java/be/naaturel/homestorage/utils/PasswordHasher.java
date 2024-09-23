package be.naaturel.homestorage.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher extends Cryptography{

    public String hash(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
