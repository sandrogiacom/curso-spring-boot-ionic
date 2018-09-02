package com.giacom.spring.ionic.cursospringionic.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {

	private Integer id;
	private String name;

	public Categoria(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Categoria categoria = (Categoria) o;
		return Objects.equals(id, categoria.id) &&
			Objects.equals(name, categoria.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
