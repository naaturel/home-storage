package be.naaturel.homestorage.controlers;

import be.naaturel.homestorage.infrastucture.UserEntity;
import be.naaturel.homestorage.models.User;
import be.naaturel.homestorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<UserEntity> register(@RequestBody User u){
        userService.register(u);
        return ResponseEntity.ok(null);
    }
}
