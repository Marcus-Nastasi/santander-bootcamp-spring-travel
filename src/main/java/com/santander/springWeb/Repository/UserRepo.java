package com.santander.springWeb.Repository;

import com.santander.springWeb.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value="SELECT * FROM users u WHERE u.email = ?", nativeQuery=true)
    User findByEmailAddress(String emailAddress);
}


