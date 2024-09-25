package be.naaturel.homestorage.controlers;

import be.naaturel.homestorage.models.User;
import be.naaturel.homestorage.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserDetailsServiceImpl userService;

    @Autowired
    public UserController(UserDetailsServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<User> register(@RequestBody User u){
        userService.register(u);
        return ResponseEntity.ok(u);
    }

    @PostMapping("/api/user/authenticate")
    public ResponseEntity<User> authenticate(@RequestBody User u){
        if(userService.authenticate(u)){
            return ResponseEntity.ok(u);
        }

        return ResponseEntity.ok(null);
    }

}
