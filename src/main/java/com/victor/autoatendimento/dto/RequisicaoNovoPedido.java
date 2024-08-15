package com.victor.autoatendimento.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RequisicaoNovoPedido {

    public RequisicaoNovoPedido(String pratos) {
        this.pratos = pratos;
    }

    private String pratos;

    public String getPratos() {
        return pratos;
    }

    public void setPratos(String pratos) {
        this.pratos = pratos;
    }

    public List<Long> getListaID() {
        String listaIDString[] = pratos.split(",");
        List<Long> listaID = Arrays.stream(listaIDString).map(Long::valueOf).collect(Collectors.toList());
        return listaID;
    }

}
