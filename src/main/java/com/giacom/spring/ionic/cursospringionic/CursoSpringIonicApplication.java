package com.giacom.spring.ionic.cursospringionic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.giacom.spring.ionic.cursospringionic.domain.Categoria;
import com.giacom.spring.ionic.cursospringionic.domain.Cidade;
import com.giacom.spring.ionic.cursospringionic.domain.Estado;
import com.giacom.spring.ionic.cursospringionic.domain.Produto;
import com.giacom.spring.ionic.cursospringionic.repositories.CategoriaRepository;
import com.giacom.spring.ionic.cursospringionic.repositories.CidadeRepository;
import com.giacom.spring.ionic.cursospringionic.repositories.EstadoRepository;
import com.giacom.spring.ionic.cursospringionic.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoSpringIonicApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringIonicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000d);
        Produto p2 = new Produto(null, "Impressora", 800d);
        Produto p3 = new Produto(null, "Mouse", 30d);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlandia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
