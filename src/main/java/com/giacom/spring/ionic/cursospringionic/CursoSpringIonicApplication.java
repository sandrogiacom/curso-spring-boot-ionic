package com.giacom.spring.ionic.cursospringionic;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.giacom.spring.ionic.cursospringionic.domain.Categoria;
import com.giacom.spring.ionic.cursospringionic.domain.Cidade;
import com.giacom.spring.ionic.cursospringionic.domain.Cliente;
import com.giacom.spring.ionic.cursospringionic.domain.Endereco;
import com.giacom.spring.ionic.cursospringionic.domain.Estado;
import com.giacom.spring.ionic.cursospringionic.domain.Pagamento;
import com.giacom.spring.ionic.cursospringionic.domain.PagamentoComBoleto;
import com.giacom.spring.ionic.cursospringionic.domain.PagamentoComCartao;
import com.giacom.spring.ionic.cursospringionic.domain.Pedido;
import com.giacom.spring.ionic.cursospringionic.domain.Produto;
import com.giacom.spring.ionic.cursospringionic.domain.enums.EstadoPagamento;
import com.giacom.spring.ionic.cursospringionic.domain.enums.TipoCliente;
import com.giacom.spring.ionic.cursospringionic.repositories.CategoriaRepository;
import com.giacom.spring.ionic.cursospringionic.repositories.CidadeRepository;
import com.giacom.spring.ionic.cursospringionic.repositories.ClienteRepository;
import com.giacom.spring.ionic.cursospringionic.repositories.EnderecoRepository;
import com.giacom.spring.ionic.cursospringionic.repositories.EstadoRepository;
import com.giacom.spring.ionic.cursospringionic.repositories.PagamentoRepository;
import com.giacom.spring.ionic.cursospringionic.repositories.PedidoRepository;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

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

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "23232323232", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("272727272", "773772828"));

        Endereco e1 = new Endereco(null, "Rua Flores", "333", "Apto 333", "Jardin", "23232322", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "222", "Apto 222", "Centro", "8383733", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.save(cli1);
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

    }
}
