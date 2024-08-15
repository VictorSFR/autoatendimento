package com.victor.autoatendimento.controller;

import com.victor.autoatendimento.dto.PratoDtoAdm;
import com.victor.autoatendimento.dto.RequisicaoNovoPedido;
import com.victor.autoatendimento.model.Mesa;
import com.victor.autoatendimento.model.Prato;
import com.victor.autoatendimento.repository.MesaRepository;
import com.victor.autoatendimento.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping("/cardapio")
public class CardapioController {
    
    //lista de itens do pedido
    private ArrayList<PratoDtoAdm> listaPratosPedido;
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
        List<PratoDtoAdm> listaPratosDTO = PratoDtoAdm.retornaListaDTO(listaPratos);
        model.addAttribute("listaPratosDTO", listaPratosDTO);

        this.listaPratosPedido = new ArrayList<PratoDtoAdm>(listaPratosDTO);
        System.out.println("Recuperei lista de pratos.");
        return "cardapio";
    }


    @PostMapping (value = "novopedido", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public String novoPedido(RequisicaoNovoPedido requisicaoNovoPedido, Model model) {
        System.out.println("RODEEEEEI");



        System.out.println("Lista no controller");
        this.listaPratosPedido.forEach(pratoDtoAdm -> System.out.println(pratoDtoAdm.getId()));

        System.out.println(requisicaoNovoPedido.getListaID());
        this.listaPratosPedido.removeIf(i -> (!requisicaoNovoPedido.getListaID().contains(i.getId())));
        System.out.println("Lista após remoção");

        this.listaPratosPedido.forEach(pratoDtoAdm -> System.out.println(pratoDtoAdm.getId()));
        return "pedido/novopedido";
    }
}
