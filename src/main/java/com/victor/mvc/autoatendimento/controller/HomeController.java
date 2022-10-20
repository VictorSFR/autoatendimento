package com.victor.mvc.autoatendimento.controller;

import com.victor.mvc.autoatendimento.model.Prato;
import com.victor.mvc.autoatendimento.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.victor.mvc.autoatendimento.dto.PratoDto;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    PratoRepository pratoRepository;

    @GetMapping(value = "/home")
    public String home(Model model){
            List<Prato> listaPratos = pratoRepository.findAll();

        try {
            BufferedImage bImage = ImageIO.read(new File("/home/victor/Downloads/picanha.jpg"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            byte [] bytes = bos.toByteArray();
            for(Prato prato:listaPratos){
                prato.setImagem(bytes);
            }
        }catch (Exception e){
            System.out.println("Houve um erro");
        }

        List<PratoDto> listaPratosDTO = PratoDto.retornaDTO(listaPratos);
        model.addAttribute("listaPratosDTO",listaPratosDTO);




        return "home";


    }

}
