package com.victor.mvc.autoatendimento.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class RequisicaoEditarPrato {

    private Long id;

    private String nomePrato;

    private String valorPrato;

    private String descricaoPrato;
    //TODO Realizar bean validation imagem prato
    private String imagemPrato;

    public RequisicaoEditarPrato(Long id, String nomePrato, String valorPrato, String descricaoPrato, String imagemPrato) {
        this.id = id;
        this.nomePrato = nomePrato;
        this.valorPrato = valorPrato;
        this.descricaoPrato = descricaoPrato;
        this.imagemPrato = imagemPrato;
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
