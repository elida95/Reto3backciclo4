package com.limpieza.controller;

import com.limpieza.model.Clean;
import com.limpieza.service.CleanService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desarrolloextremo
 */
@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class CleanController {

    @Autowired
    private CleanService servicio;

    @GetMapping("/all")
    public List<Clean> listAll() {
        return servicio.listAll();
    }

    @GetMapping("/{id}")
    public Optional<Clean> getSupplement(@PathVariable("id") Integer id) {
        return servicio.getClean(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clean create(@RequestBody Clean gadget) {
        return servicio.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clean update(@RequestBody Clean gadget) {
        return servicio.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return servicio.delete(id);
    }
}
