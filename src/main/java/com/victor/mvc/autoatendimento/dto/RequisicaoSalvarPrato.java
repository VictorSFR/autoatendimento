package com.victor.mvc.autoatendimento.dto;

import com.victor.mvc.autoatendimento.model.Prato;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotBlank;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RequisicaoSalvarPrato {
    private Long id;
    @NotBlank
    private String nomePrato;
    @NotBlank
    private String valorPrato;
    @NotBlank
    private String descricaoPrato;
    //TODO Realizar bean validation imagem prato

    private MultipartFile imagemPrato;

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getValorPrato() {
        return valorPrato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MultipartFile getImagemPrato() {
        return imagemPrato;
    }

    public void setImagemPrato(MultipartFile imagemPrato) {
        this.imagemPrato = imagemPrato;
    }

    public Prato toPrato() {
        Prato prato = new Prato();
        prato.setNomePrato(this.nomePrato);
        prato.setDescricao(this.descricaoPrato);
        prato.setValor(BigDecimal.valueOf(Double.valueOf(this.valorPrato)));
        try {

            File file = new File(toFile(imagemPrato).getFileName().toString());
            BufferedImage bImage = ImageIO.read(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            byte[] bytes = bos.toByteArray();
            prato.setImagem(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prato;
    }

    private Path toFile(MultipartFile file) {

        Path newFile = Paths.get(file.getOriginalFilename());
        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(newFile)) {
            byte[] buffer = new byte[4096];
            int read = 0;

            while ((read = is.read(buffer)) > 0) {
                os.write(buffer, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFile;
    }
}
