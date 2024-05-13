package com.userauthenticationandmanagement.user_authentication.Service;

import com.userauthenticationandmanagement.user_authentication.Model.UserRegistration;
import com.userauthenticationandmanagement.user_authentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserRegistration registerUser(UserRegistration user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserRegistration loginUser(String usernameOrEmail, String password) {
        UserRegistration user = userRepository.findByEmail(usernameOrEmail);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Perform login logic
            return user;
        }
        return null;
    }


    @Override
    public void logoutUser(String userId) {

    }

//    @Override
//    public UserRegistration loginUser(String email, String password) {
//        UserRegistration user = userRepository.findByEmail(email);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            // Perform login logic, e.g., generate JWT token
//            String jwtToken = jwtUtil.generateToken(user.getId());
//            // Set JWT token in user object (if needed)
//            user.setToken(jwtToken);
//            return user;
//        }
//        return null;
//    }

//    @Override
//    public void logoutUser(String userId) {
//        // Clear user's session (if applicable)
//        sessionService.clearSession(userId);
//
//        // Invalidate tokens (if applicable)
//        jwtUtil.invalidateToken(userId);
//    }

    @Override
    public UserRegistration getUserProfile(String userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
