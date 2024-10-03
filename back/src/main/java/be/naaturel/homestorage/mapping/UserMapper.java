package be.naaturel.homestorage.mapping;

import be.naaturel.homestorage.infrastucture.UserEntity;
import be.naaturel.homestorage.models.User;

public class UserMapper {

    public static UserEntity toEntity(User u) {

        UserEntity ue = new UserEntity();
        ue.setName(u.getName());
        ue.setPassword(u.getPassword());

        return ue;
    }

    public static User toUser(UserEntity ue) {
        return new User(ue.getId(), ue.getUsername(), ue.getPassword());
    }


}
