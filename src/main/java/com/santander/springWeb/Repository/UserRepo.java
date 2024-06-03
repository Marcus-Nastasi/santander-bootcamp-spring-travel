package com.santander.springWeb.Repository;

import com.santander.springWeb.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    UserDetails findByEmail(String email);

    @Query(value="SELECT * FROM users u WHERE u.email = ?", nativeQuery=true)
    User findByEmailAddress(String emailAddress);

    //@Query(value = "SELECT u.*, r.* FROM users u INNER JOIN reserve r ON r.id_user = u.id;", nativeQuery = true)
}


