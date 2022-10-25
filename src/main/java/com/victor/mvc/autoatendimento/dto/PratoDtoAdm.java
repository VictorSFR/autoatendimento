package com.victor.mvc.autoatendimento.dto;

import com.victor.mvc.autoatendimento.model.Prato;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

public class PratoDtoAdm {
    private Long id;
    private String nomePrato;
    private BigDecimal valor;
    private String descricao;
    private String imagem;


    public PratoDtoAdm(Prato prato) {
        this.id = prato.getId();
        this.nomePrato = prato.getNomePrato();
        this.descricao = prato.getDescricao();
        this.valor = prato.getValor();
        this.imagem = converter(prato.getImagem());
    }

    public String converter(byte[] byteStream) {

        return "data:image/png;base64," + Base64.getEncoder().encodeToString(byteStream);
    }

    public static List<PratoDtoAdm> retornaListaDTO(List<Prato> listaPratos) {
        Stream<PratoDtoAdm> pratoDtoStream = listaPratos.stream().map(PratoDtoAdm::new);
        return pratoDtoStream.toList();
    }


    public String getNomePrato() {
        return nomePrato;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
