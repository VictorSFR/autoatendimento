package com.victor.autoatendimento.dto;


import com.victor.autoatendimento.model.Prato;

import java.util.Base64;

public class RequisicaoEditarPrato {

    private Long id;

    private String nomePrato;

    private String valorPrato;

    private String descricaoPrato;
    //TODO Realizar bean validation imagem prato
    private String imagemPrato;

    public RequisicaoEditarPrato() {
    }

    public RequisicaoEditarPrato(Prato prato){
        this.id = prato.getId();
        this.nomePrato = prato.getNomePrato();
        this.valorPrato = prato.getValor().toString();
        this.descricaoPrato = prato.getDescricao();
        this.imagemPrato = converter(prato.getImagem());
    }
    public String converter(byte[] byteStream) {

        return "data:image/png;base64," + Base64.getEncoder().encodeToString(byteStream);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getValorPrato() {
        return valorPrato;
    }

    public void setValorPrato(String valorPrato) {
        this.valorPrato = valorPrato;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }

    public String getImagemPrato() {
        return imagemPrato;
    }

    public void setImagemPrato(String imagemPrato) {
        this.imagemPrato = imagemPrato;
    }
}
