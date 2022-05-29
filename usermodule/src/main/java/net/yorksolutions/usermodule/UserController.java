package net.yorksolutions.usermodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
public class UserController {
    private UserService service;

    @Autowired
    public UserController(@NonNull UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    @CrossOrigin
    UUID login(@RequestParam String username, @RequestParam String password) {
        return service.login(username, password);
    }

    @GetMapping("/register")
    @CrossOrigin
    public void register(@RequestParam String username, @RequestParam String password) {
        service.register(username, password);
    }

    @GetMapping("/isAuthorized")
    @CrossOrigin
    public void isAuthorized(@RequestParam UUID token) {
        service.isAuthorized(token);
    }

    public void setService(UserService service) {
        this.service = service;
    }
}
