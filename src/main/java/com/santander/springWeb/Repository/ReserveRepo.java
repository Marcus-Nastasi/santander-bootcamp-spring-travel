package com.santander.springWeb.Repository;

import com.santander.springWeb.DTO.UserOnReserveDTO;
import com.santander.springWeb.Models.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepo extends JpaRepository<Reserve, Integer> {

    @Query(value = "SELECT u.*, r.* FROM users u INNER JOIN reserve r ON r.id_user = u.id;", nativeQuery = true)
    List<UserOnReserveDTO> findUserOnReserve();
}



