package com.victor.autoatendimento.dto;

public class RequisicaoDeletarPrato {

    private Long id;

    public RequisicaoDeletarPrato(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
