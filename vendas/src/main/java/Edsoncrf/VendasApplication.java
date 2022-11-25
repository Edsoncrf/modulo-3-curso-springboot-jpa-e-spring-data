package Edsoncrf;

import Edsoncrf.domain.entity.Cliente;
import Edsoncrf.domain.entity.Pedido;
import Edsoncrf.domain.repository.Clientes;
import Edsoncrf.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos){
        return args -> {
            System.out.println("Salvando clientes");
            Cliente edson2 = new Cliente("Edson2");
            clientes.save(edson2);

            Pedido p = new Pedido();
            p.setCliente(edson2);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

//            Cliente cliente = clientes.findClienteFetchPedidos(edson2.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());
            pedidos.findByCliente(edson2).forEach(System.out::println);

        };
    }
    public static void main(String[] args) {

        SpringApplication.run(VendasApplication.class, args);
    }
}
