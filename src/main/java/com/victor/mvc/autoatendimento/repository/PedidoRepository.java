package com.victor.mvc.autoatendimento.repository;
import com.victor.mvc.autoatendimento.model.Mesa;
import com.victor.mvc.autoatendimento.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface PedidoRepository {
    List<Pedido> findAll();

}
