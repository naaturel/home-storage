package be.naaturel.homestorage.mapping;

import be.naaturel.homestorage.infrastucture.UserEntity;
import be.naaturel.homestorage.models.User;

public class UserMapper {

    public static UserEntity toEntity(User u) {


        UserEntity ue = new UserEntity();
        ue.name = u.getName();
        ue.password = u.getPassword();

        return ue;
    }

}
