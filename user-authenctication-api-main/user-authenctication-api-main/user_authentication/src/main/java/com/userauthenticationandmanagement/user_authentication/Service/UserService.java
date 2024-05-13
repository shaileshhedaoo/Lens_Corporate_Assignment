package com.userauthenticationandmanagement.user_authentication.Service;

import com.userauthenticationandmanagement.user_authentication.Model.UserRegistration;

public interface UserService {
    UserRegistration registerUser(UserRegistration user);
    UserRegistration loginUser(String usernameOrEmail, String password);
    void logoutUser(String userId);
    UserRegistration getUserProfile(String userId);
}
