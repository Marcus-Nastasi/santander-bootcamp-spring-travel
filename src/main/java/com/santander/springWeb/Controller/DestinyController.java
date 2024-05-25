package com.santander.springWeb.Controller;

import com.santander.springWeb.Models.Destiny;
import com.santander.springWeb.Repository.DestinyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DestinyController {

    @Autowired
    private DestinyRepo destinyRepo;

    @GetMapping(value = "/api/destiny")
    public List<Destiny> readAll() {
        return destinyRepo.findAll();
    }

    @GetMapping(value = "/api/destiny/{id}")
    public Destiny readSingle(@PathVariable("id") int id) {
        return destinyRepo.findById(id).get();
    }

    @PostMapping(value = "/api/destiny/add")
    public void insertDestiny(@RequestBody Destiny destiny) {
        destinyRepo.save(destiny);
    }

    @PutMapping(value = "/api/destiny/{id}/update")
    public void updateDestiny(@PathVariable("id") int id, @RequestBody Destiny destiny) {
        Destiny toUpdate = destinyRepo.findById(id).get();
        toUpdate.update(destiny);
        destinyRepo.save(toUpdate);
    }

    @DeleteMapping(value = "/api/destiny/{id}/delete")
    public void deleteDestiny(@PathVariable("id") int id) {
        destinyRepo.deleteById(id);
    }
}



