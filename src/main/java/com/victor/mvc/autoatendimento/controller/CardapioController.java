package com.victor.mvc.autoatendimento.controller;

import com.victor.mvc.autoatendimento.model.Prato;
import com.victor.mvc.autoatendimento.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.victor.mvc.autoatendimento.dto.PratoDtoClient;

import java.util.List;

@Controller
public class CardapioController {
    @Autowired
    PratoRepository pratoRepository;

    @GetMapping(value = "/cardapio")
    public String cardapio(Model model) {
        List<Prato> listaPratos = pratoRepository.findAll();

        List<PratoDtoClient> listaPratosDTO = PratoDtoClient.retornaListaDTO(listaPratos);
        model.addAttribute("listaPratosDTO", listaPratosDTO);


        return "cardapio";

    }


    @GetMapping(value = "/cardapio/novopedido")
    public String novoPedido(String nomePrato, Model model) {
        Prato prato = pratoRepository.findByNomePrato(nomePrato);
        PratoDtoClient pratoDtoClient = new PratoDtoClient(prato);
        model.addAttribute("prato", pratoDtoClient);

        return "cardapio/novopedido";
    }
}
