package com.giacom.spring.ionic.cursospringionic.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giacom.spring.ionic.cursospringionic.domain.Categoria;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResource {

	@GetMapping
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");

		List<Categoria> result = new ArrayList<>();
		result.add(cat1);
		result.add(cat2);

		return result;
	}

}
