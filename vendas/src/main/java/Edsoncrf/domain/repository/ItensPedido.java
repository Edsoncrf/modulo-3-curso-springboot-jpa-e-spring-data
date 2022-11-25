package Edsoncrf.domain.repository;

import Edsoncrf.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<Pedido, Integer> {
}
