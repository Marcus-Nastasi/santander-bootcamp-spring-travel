package com.santander.springWeb.Controller;

import com.santander.springWeb.Models.Reserve;
import com.santander.springWeb.Repository.ReserveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserve")
public class ReserveController {

    @Autowired
    private ReserveRepo reserveRepo;

    @GetMapping()
    public List<Reserve> getAll() {
        return reserveRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Reserve getSingle(@PathVariable("id") int id) {
        return reserveRepo.findById(id).get();
    }

    @PostMapping(value = "/add")
    public void insertReserve(@RequestBody Reserve reserve) {
        reserveRepo.save(reserve);
    }

    @PutMapping(value = "/{id}/update")
    public void updateReserve(@PathVariable("id") int id, @RequestBody Reserve reserve) {
        Reserve toUpdate = reserveRepo.findById(id).get();
        toUpdate.update(reserve);
        reserveRepo.save(toUpdate);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteReserve(@PathVariable("id") int id) {
        reserveRepo.deleteById(id);
    }
}



