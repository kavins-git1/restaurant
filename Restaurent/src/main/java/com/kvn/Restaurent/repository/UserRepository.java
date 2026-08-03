package com.kvn.Restaurent.repository;

import com.kvn.Restaurent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String username);
}
