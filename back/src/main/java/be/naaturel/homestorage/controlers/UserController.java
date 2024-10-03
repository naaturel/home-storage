package be.naaturel.homestorage.controlers;

import be.naaturel.homestorage.exceptions.AuthenticationException;
import be.naaturel.homestorage.models.User;
import be.naaturel.homestorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<User> register(@RequestBody User u){
        userService.register(u);
        return ResponseEntity.ok(u);
    }

    @PostMapping("/api/user/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody User u){

        User result;

        try{
            result = userService.authenticate(u);
        } catch (AuthenticationException ae){
            return new ResponseEntity<>("Wrong username or password", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(result);

    }

}
