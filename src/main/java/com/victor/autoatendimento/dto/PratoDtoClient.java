package com.victor.autoatendimento.dto;

import com.victor.autoatendimento.model.Prato;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

public class PratoDtoClient {
    private String nomePrato;
    private BigDecimal valor;
    private String descricao;
    private String imagem;

    public PratoDtoClient(Prato prato) {
        this.nomePrato = prato.getNomePrato();
        this.descricao = prato.getDescricao();
        this.valor = prato.getValor();
        this.imagem = converter(prato.getImagem());
    }

    public String converter(byte[] byteStream) {

        return "data:image/png;base64," + Base64.getEncoder().encodeToString(byteStream);
    }

    public static List<PratoDtoClient> retornaListaDTO(List<Prato> listaPratos) {
        Stream<PratoDtoClient> pratoDtoStream = listaPratos.stream().map(PratoDtoClient::new);
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
}
