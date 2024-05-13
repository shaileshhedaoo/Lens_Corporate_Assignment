package com.userauthenticationandmanagement.user_authentication.Controller;

import com.userauthenticationandmanagement.user_authentication.Model.UserRegistration;
import com.userauthenticationandmanagement.user_authentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserRegistration userRegistration;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<UserRegistration> registerUser(@RequestBody UserRegistration user) {
        // Encode password before registering the user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRegistration user) {
        String email = user.getEmail();
        String password = user.getPassword();
        UserRegistration loggedInUser = userService.loginUser(email, password);
        if (loggedInUser != null) {
            return new ResponseEntity<>("LOGIN SUCCESSFUL", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("LOGIN SUCCESSFUL", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logoutUser(@RequestParam String userId) {
        userService.logoutUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("{email}")//get user deatils using email
    public UserRegistration getUserDetailsByEmail(@RequestBody  String email)
    {
        return userRegistration;
    }
//    @GetMapping("/{username}")
//    public ResponseEntity<UserRegistration> getUserProfile(@PathVariable String username) {
//        UserRegistration user = userService.getUserProfile(userId);
//        if (user != null) {
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
