package com.victor.mvc.autoatendimento.dto;

import com.victor.mvc.autoatendimento.model.Mesa;
import net.glxn.qrgen.javase.QRCode;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

public class MesaDto {
    private Long id;
    private String qrcode;

    public MesaDto(Mesa mesa) {
        this.id = mesa.getId();
        try {
            this.qrcode = geraImagemQRCode("http://192.168.101.100:8080/cardapio/" + mesa.getCode());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<MesaDto> retornaListaMesaDTO(List<Mesa> listaMesas) {
        Stream<MesaDto> mesaDtoStream = listaMesas.stream().map(MesaDto::new);
        return mesaDtoStream.toList();
    }

    public String geraImagemQRCode(String barcodeText) throws Exception {
        ByteArrayOutputStream stream = QRCode
                .from(barcodeText)
                .withSize(800, 800)
                .stream();
        ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());
        byte[] byteArray = IOUtils.toByteArray(bis);
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(byteArray);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
