package com.giacom.spring.ionic.cursospringionic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giacom.spring.ionic.cursospringionic.domain.Cliente;
import com.giacom.spring.ionic.cursospringionic.repositories.ClienteRepository;
import com.giacom.spring.ionic.cursospringionic.services.exception.ObjectNotFountException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFountException("Não foi possível buscar o cliente pelo id: " + id));
    }

}
