package com.santander.springWeb.Repository;

import com.santander.springWeb.Models.Destiny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinyRepo extends JpaRepository<Destiny, Integer> {

    @Query(value = "SELECT d.*, r.* " +
                    "FROM destiny d " +
                    "INNER JOIN reserve r " +
                    "ON r.id_user = d.id " +
                    "WHERE(d.id = ?1)", nativeQuery = true)
    List<Object[]> findAllDestinyReserve(int id);
}


