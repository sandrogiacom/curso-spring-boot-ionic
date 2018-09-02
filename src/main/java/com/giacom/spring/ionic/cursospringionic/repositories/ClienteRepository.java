package com.giacom.spring.ionic.cursospringionic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giacom.spring.ionic.cursospringionic.domain.Cidade;
import com.giacom.spring.ionic.cursospringionic.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
