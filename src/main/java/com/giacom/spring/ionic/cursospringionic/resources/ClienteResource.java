package com.giacom.spring.ionic.cursospringionic.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giacom.spring.ionic.cursospringionic.services.ClienteService;

@RestController
@RequestMapping(value = "clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }


}
