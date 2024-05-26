package com.santander.springWeb.Controller;

import com.santander.springWeb.DTO.ReserveOnDestinyDTO;
import com.santander.springWeb.Handler.BusinessException;
import com.santander.springWeb.Models.Destiny;
import com.santander.springWeb.Repository.DestinyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/destiny")
public class DestinyController {

    @Autowired
    private DestinyRepo destinyRepo;

    @GetMapping()
    public List<Destiny> readAll() {
        return destinyRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Destiny readSingle(@PathVariable("id") int id) throws BusinessException {
        if (destinyRepo.findById(id).isEmpty()) throw new BusinessException("Destiny not found");
        return destinyRepo.findById(id).get();
    }

    @GetMapping(value = "/findAllDestinyReserve/{id}")
    public List<ReserveOnDestinyDTO> findAllDestinyReserve(@PathVariable int id) throws BusinessException {
        if (destinyRepo.findById(id).isEmpty()) throw new BusinessException("Destiny not found");
        List<Object[]> results = destinyRepo.findAllDestinyReserve(id);
        List<ReserveOnDestinyDTO> reserveOnDestinies = new ArrayList<>();

        results.forEach(o -> {
            ReserveOnDestinyDTO dto = new ReserveOnDestinyDTO((int) o[0], (String) o[1], (String) o[2], (int) o[3], (int) o[4], (int) o[5], (Date) o[6], (String) o[7]);
            reserveOnDestinies.add(dto);
        });

        return reserveOnDestinies;
    }

    @PostMapping(value = "/add")
    public void insertDestiny(@RequestBody Destiny destiny) throws BusinessException {
        if (destiny.getName() == null || destiny.getDescription() == null) throw new BusinessException("Null values");
        destinyRepo.save(destiny);
    }

    @PutMapping(value = "/{id}/update")
    public void updateDestiny(@PathVariable("id") int id, @RequestBody Destiny destiny) throws BusinessException {
        if (destinyRepo.findById(id).isEmpty()) throw new BusinessException("Destiny not found");
        if (destiny.getName() == null || destiny.getDescription() == null) throw new BusinessException("Null values");
        Destiny toUpdate = destinyRepo.findById(id).get();
        toUpdate.update(destiny);
        destinyRepo.save(toUpdate);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteDestiny(@PathVariable("id") int id) throws BusinessException {
        if (destinyRepo.findById(id).isEmpty()) throw new BusinessException("Destiny not found");
        destinyRepo.deleteById(id);
    }
}



