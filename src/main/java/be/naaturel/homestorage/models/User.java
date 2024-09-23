package be.naaturel.homestorage.models;

import be.naaturel.homestorage.utils.PasswordHasher;

public class User {

    private String name;
    private String password;

    private boolean hasBeenHashed = false;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public void hashPassword(){
        if(hasBeenHashed)  return;
        PasswordHasher pwdHasher = new PasswordHasher();
        this.password = pwdHasher.hash(this.password);
        hasBeenHashed = true;
        System.out.println(password);
    }
}
