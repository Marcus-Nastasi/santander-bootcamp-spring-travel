package com.santander.springWeb.Repository;

import com.santander.springWeb.Models.Destiny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinyRepo extends JpaRepository<Destiny, Integer> {
}


