package com.victor.autoatendimento.model;
    import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private List<String> pratos;
    private Mesa Mesa;
    private BigDecimal valor;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getPratos() {
        return pratos;
    }

    public void setPratos(List<String> pratos) {
        this.pratos = pratos;
    }

    public com.victor.autoatendimento.model.Mesa getMesa() {
        return Mesa;
    }

    public void setMesa(com.victor.autoatendimento.model.Mesa mesa) {
        Mesa = mesa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
