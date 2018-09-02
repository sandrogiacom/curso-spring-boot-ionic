package com.giacom.spring.ionic.cursospringionic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giacom.spring.ionic.cursospringionic.domain.Cliente;
import com.giacom.spring.ionic.cursospringionic.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
