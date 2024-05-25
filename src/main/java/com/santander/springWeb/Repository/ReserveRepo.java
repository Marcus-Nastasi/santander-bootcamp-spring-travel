package com.santander.springWeb.Repository;

import com.santander.springWeb.Models.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepo extends JpaRepository<Reserve, Integer> {
}



