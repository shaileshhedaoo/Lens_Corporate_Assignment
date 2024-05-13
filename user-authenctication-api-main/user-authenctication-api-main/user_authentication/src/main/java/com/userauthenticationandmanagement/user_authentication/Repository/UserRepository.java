package com.userauthenticationandmanagement.user_authentication.Repository;

import com.userauthenticationandmanagement.user_authentication.Model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, String> {
    UserRegistration findByEmail(String email);
}
