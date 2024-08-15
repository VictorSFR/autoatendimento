package com.victor.autoatendimento.controller;
import com.victor.autoatendimento.dto.*;
import com.victor.autoatendimento.model.Prato;
import com.victor.autoatendimento.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;


import java.util.*;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Transactional
@Controller
@RequestMapping("pratos")
public class PratoController {
    @Autowired
    private PratoRepository pratoRepository;

    @GetMapping("listagem")
    public String pratos(Model model) {
        List<Prato> listaPratos = pratoRepository.findAll();

        List<PratoDtoAdm> listaPratosDTOAdm = PratoDtoAdm.retornaListaDTO(listaPratos);
        model.addAttribute("listaPratosDTOAdm", listaPratosDTOAdm);

        return "prato/listagempratos";
    }

    @PostMapping("editar")
    public String editarPrato(RequisicaoEditarPrato requisicaoEditarPrato, Model model) {
        Optional<Prato> pratoOpt = pratoRepository.findById(requisicaoEditarPrato.getId());
        requisicaoEditarPrato = new RequisicaoEditarPrato(pratoOpt.get());
        model.addAttribute("requisicaoEditarPrato",requisicaoEditarPrato);
        return "prato/editarprato";
    }

    @PostMapping("editarprato")
    public String atualizarPrato(RequisicaoSalvarPrato requisicaoSalvarPratoPrato, Model model) {

        Prato pratoRecebido = requisicaoSalvarPratoPrato.toPrato();

        Optional<Prato> pratoOpt = pratoRepository.findById(requisicaoSalvarPratoPrato.getId());
        Prato pratoDb = pratoOpt.get();
        if (pratoRecebido.getImagem()!=null){
            pratoDb.setNomePrato(pratoRecebido.getNomePrato());
            pratoDb.setDescricao(pratoRecebido.getDescricao());
            pratoDb.setValor(pratoRecebido.getValor());
            pratoDb.setImagem(pratoRecebido.getImagem());
        }



        return "redirect:/pratos/listagem";
    }

    @PostMapping("deletar")
    public String deletarPrato(RequisicaoDeletarPrato requisicaoDeletarPrato) {

        pratoRepository.deleteById(requisicaoDeletarPrato.getId());

        return ("redirect:/pratos/listagem");
    }

    @GetMapping("novoprato")
    public String novoPrato(RequisicaoSalvarPrato requisicaoSalvarPrato) {
        return "prato/novoprato";
    }

    @PostMapping(value = "salvarprato", consumes = MULTIPART_FORM_DATA_VALUE)
    public String salvarPrato(@Valid RequisicaoSalvarPrato requisicaoSalvarPrato, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "prato/novoprato";
        }


        Prato prato = requisicaoSalvarPrato.toPrato();
        if (prato.getImagem() != null) {
            pratoRepository.save(prato);

        }

        return "redirect:/pratos/listagem";
    }


}
