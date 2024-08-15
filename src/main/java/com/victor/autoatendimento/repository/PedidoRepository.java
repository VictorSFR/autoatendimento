package com.victor.autoatendimento.repository;
import com.victor.autoatendimento.model.Pedido;

import java.util.List;

public interface PedidoRepository {
    List<Pedido> findAll();

}
