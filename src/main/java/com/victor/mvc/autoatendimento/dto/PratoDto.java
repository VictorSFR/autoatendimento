package com.victor.mvc.autoatendimento.dto;

import com.victor.mvc.autoatendimento.model.Prato;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

public class PratoDto {
    private Long id;
    private String nomePrato;
    private BigDecimal valor;
    private String descricao;
    private String imagem;

    public PratoDto(Prato prato) {
        this.id = prato.getId();
        this.nomePrato = prato.getNomePrato();
        this.descricao = prato.getDescricao();
        this.valor = prato.getValor();
        this.imagem = converter(prato.getImagem());
    }

    public String converter(byte[] byteStream){

        return "data:image/png;base64,"+Base64.getEncoder().encodeToString(byteStream);
    }
    public static List<PratoDto> retornaDTO(List<Prato> listaPratos){
        Stream<PratoDto> pratoDtoStream = listaPratos.stream().map(PratoDto::new);
        return  pratoDtoStream.toList();
    }

    public Long getId() {
        return id;
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
}
