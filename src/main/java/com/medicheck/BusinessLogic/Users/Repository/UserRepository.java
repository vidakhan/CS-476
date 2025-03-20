package com.medicheck.BusinessLogic.Users.Repository;


import com.medicheck.BusinessLogic.Users.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}