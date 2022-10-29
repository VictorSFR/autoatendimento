package com.victor.mvc.autoatendimento.controller;

import com.victor.mvc.autoatendimento.model.Mesa;
import com.victor.mvc.autoatendimento.model.Prato;
import com.victor.mvc.autoatendimento.repository.MesaRepository;
import com.victor.mvc.autoatendimento.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.victor.mvc.autoatendimento.dto.PratoDtoClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cardapio")
public class CardapioController {
    @Autowired
    PratoRepository pratoRepository;
    @Autowired
    MesaRepository mesaRepository;

    @GetMapping(value = "/{code}")
    public String cardapio(@PathVariable String code) {
        System.out.println("Recebi uma requisição para mostrar cardapio");
        System.out.println(code);

        Mesa mesa = mesaRepository.findByCode(code);
        if (mesa != null) {
            return "redirect:/cardapio/ver";
        }
        /*List<Prato> listaPratos = pratoRepository.findAll();

        List<PratoDtoClient> listaPratosDTO = PratoDtoClient.retornaListaDTO(listaPratos);
        model.addAttribute("listaPratosDTO", listaPratosDTO);*/


        return "";

    }

    @GetMapping(value = "ver")
    public String mostrarCardapio(Model model) {
        List<Prato> listaPratos = pratoRepository.findAll();

        List<PratoDtoClient> listaPratosDTO = PratoDtoClient.retornaListaDTO(listaPratos);
        model.addAttribute("listaPratosDTO", listaPratosDTO);
        System.out.println("Recuperei lista de pratos.");
        return "";
    }


    @GetMapping(value = "/cardapio/novopedido")
    public String novoPedido(String nomePrato, Model model) {
        Prato prato = pratoRepository.findByNomePrato(nomePrato);
        PratoDtoClient pratoDtoClient = new PratoDtoClient(prato);
        model.addAttribute("prato", pratoDtoClient);

        return "cardapio/novopedido";
    }
}
