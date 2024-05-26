package com.santander.springWeb.Controller;

import com.santander.springWeb.Handler.BusinessException;
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
    public Reserve getSingle(@PathVariable("id") int id) throws BusinessException {
        if (reserveRepo.findById(id).isEmpty()) throw new BusinessException("Reserve not found.");
        return reserveRepo.findById(id).get();
    }

    @PostMapping(value = "/add")
    public void insertReserve(@RequestBody Reserve reserve) throws BusinessException {
        if (reserve.getReserve_date() == null || reserve.getStatus() == null
                || reserve.getId_user() <= 0 || reserve.getId_destiny() <= 0) throw new BusinessException("Null values.");
        reserveRepo.save(reserve);
    }

    @PutMapping(value = "/{id}/update")
    public void updateReserve(@PathVariable("id") int id, @RequestBody Reserve reserve) throws BusinessException {
        if (reserveRepo.findById(id).isEmpty()) throw new BusinessException("Reserve not finded");
        if (reserve.getReserve_date() == null || reserve.getStatus() == null
                || reserve.getId_user() <= 0 || reserve.getId_destiny() <= 0) throw new BusinessException("Null values.");
        Reserve toUpdate = reserveRepo.findById(id).get();
        toUpdate.update(reserve);
        reserveRepo.save(toUpdate);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteReserve(@PathVariable("id") int id) throws BusinessException {
        if (reserveRepo.findById(id).isEmpty()) throw new BusinessException("Reserve not finded");
        reserveRepo.deleteById(id);
    }
}



