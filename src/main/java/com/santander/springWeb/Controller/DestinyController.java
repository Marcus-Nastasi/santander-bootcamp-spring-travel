package com.santander.springWeb.Controller;

import com.santander.springWeb.Models.Destiny;
import com.santander.springWeb.Repository.DestinyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Destiny readSingle(@PathVariable("id") int id) {
        return destinyRepo.findById(id).get();
    }

    @PostMapping(value = "/add")
    public void insertDestiny(@RequestBody Destiny destiny) {
        destinyRepo.save(destiny);
    }

    @PutMapping(value = "/{id}/update")
    public void updateDestiny(@PathVariable("id") int id, @RequestBody Destiny destiny) {
        Destiny toUpdate = destinyRepo.findById(id).get();
        toUpdate.update(destiny);
        destinyRepo.save(toUpdate);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteDestiny(@PathVariable("id") int id) {
        destinyRepo.deleteById(id);
    }
}



