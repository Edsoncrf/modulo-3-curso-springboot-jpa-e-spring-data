package Edsoncrf.domain.repository;

import Edsoncrf.domain.entity.Cliente;
import Edsoncrf.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
