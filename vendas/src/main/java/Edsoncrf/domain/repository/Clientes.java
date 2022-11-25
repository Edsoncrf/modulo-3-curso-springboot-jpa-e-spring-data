package Edsoncrf.domain.repository;

import Edsoncrf.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM cliente c WHERE c.nome LIKE '%:nome%'", nativeQuery = true)
    List<Cliente> encontraPorNome(@Param("nome") String nome);

    @Query("DELETE FROM Cliente c WHERE c.nome = :nome")
    @Modifying //para update e delete usasse essa anotação
    void deleteByNome(String nome);

    boolean existsByNome(String nome);
    @Query("SELECT c FROM Cliente c LEFT JOIN FETCH c.pedidos WHERE c.id = :id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

}
