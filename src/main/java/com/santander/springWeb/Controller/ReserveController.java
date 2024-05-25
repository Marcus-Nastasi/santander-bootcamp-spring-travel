package com.santander.springWeb.Controller;

import com.santander.springWeb.Models.Reserve;
import com.santander.springWeb.Repository.ReserveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReserveController {

    @Autowired
    private ReserveRepo reserveRepo;

    @GetMapping(value = "/api/reserve")
    public List<Reserve> getAll() {
        return reserveRepo.findAll();
    }
}



