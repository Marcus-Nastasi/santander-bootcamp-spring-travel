package com.santander.springWeb.Repository;

import com.santander.springWeb.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}


