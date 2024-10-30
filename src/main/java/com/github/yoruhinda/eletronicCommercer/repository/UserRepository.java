package com.github.yoruhinda.eletronicCommercer.repository;

import com.github.yoruhinda.eletronicCommercer.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
}
