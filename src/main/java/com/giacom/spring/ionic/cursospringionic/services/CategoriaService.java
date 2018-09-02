package com.giacom.spring.ionic.cursospringionic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giacom.spring.ionic.cursospringionic.domain.Categoria;
import com.giacom.spring.ionic.cursospringionic.repositories.CategoriaRepository;
import com.giacom.spring.ionic.cursospringionic.services.exception.ObjectNotFountException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFountException("Não foi possível buscar categoria pelo id: " + id));
	}

}
