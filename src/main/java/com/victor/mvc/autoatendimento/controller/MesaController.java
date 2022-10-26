package com.victor.mvc.autoatendimento.controller;

import com.victor.mvc.autoatendimento.dto.MesaDto;
import com.victor.mvc.autoatendimento.model.Mesa;
import com.victor.mvc.autoatendimento.repository.MesaRepository;
import net.bytebuddy.utility.RandomString;
import net.glxn.qrgen.javase.QRCode;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.List;

@RequestMapping("mesas")
@Controller
public class MesaController {
    @Autowired
    MesaRepository mesaRepository;

    @GetMapping("novamesa")
    public String novaMesa(){
        Mesa mesa = new Mesa(RandomString.make(10));
        System.out.println("Gerei uma novo cod mesa: "+mesa.getCode());
        mesaRepository.save(mesa);

        return "redirect:/mesas/listagem";
    }
    @PostMapping("deletar")
    public String deletarMesa(Mesa mesa){
        System.out.println("Recebi uma requisição para deletar uma mesa.");
        mesaRepository.deleteById(mesa.getId());
        return "redirect:/mesas/listagem";
    }
    @GetMapping("listagem")
    public String listarMesas(Model model){
        List<Mesa> listaMesa = mesaRepository.findAll();
        List<MesaDto> mesaDtos = MesaDto.retornaListaMesaDTO(listaMesa);
        model.addAttribute("listaMesas",mesaDtos);
        return "mesa/listagemdemesas";
    }
    //TODO criar método deletar mesa
    //TODO criar método listar mesas



}
