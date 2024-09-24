package be.naaturel.homestorage.utils;


import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHasher extends Cryptography{


    public String hash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean check(String predicate, String hash){
        return BCrypt.checkpw(predicate, hash);
    }
}
