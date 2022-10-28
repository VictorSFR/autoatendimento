package com.victor.mvc.autoatendimento.controller;

import com.victor.mvc.autoatendimento.dto.*;
import com.victor.mvc.autoatendimento.model.Prato;
import com.victor.mvc.autoatendimento.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
@Transactional
@Controller
@RequestMapping("pratos")
public class PratoController {
    @Autowired
    private PratoRepository pratoRepository;
    @GetMapping("listagem")
    public String pratos(Model model){
        List<Prato> listaPratos = pratoRepository.findAll();

        List<PratoDtoAdm> listaPratosDTOAdm = PratoDtoAdm.retornaListaDTO(listaPratos);
        model.addAttribute("listaPratosDTOAdm", listaPratosDTOAdm);

        return "prato/listagempratos";
    }
    @PostMapping("editar")
    public String editarPrato(RequisicaoEditarPrato requisicaoEditarPrato, Model model){
        System.out.println("Recebi uma requisição para editar um prato.");
        System.out.println(requisicaoEditarPrato.getNomePrato());
        return "prato/editarprato";
    }
    @PostMapping("editarprato")
    public String atualizarPrato(RequisicaoSalvarPrato requisicaoSalvarPratoPrato, Model model){
        System.out.println("Recebi uma requisição para atualizar um prato.");
        Prato pratoRecebido = requisicaoSalvarPratoPrato.toPrato();
        Prato pratoDb = pratoRepository.findByNomePrato(requisicaoSalvarPratoPrato.getNomePrato());
        pratoDb.setNomePrato(pratoRecebido.getNomePrato());
        pratoDb.setDescricao(pratoRecebido.getDescricao());
        pratoDb.setValor(pratoRecebido.getValor());
        pratoDb.setImagem(pratoRecebido.getImagem());
        pratoRepository.save(pratoDb);

        return "redirect:/pratos/listagem";
    }

    @PostMapping("deletar")
    public String deletarPrato(RequisicaoDeletarPrato requisicaoDeletarPrato){
        System.out.println("Recebi uma requisição para deletar um prato.");
        System.out.println("Recebi um ID: "+requisicaoDeletarPrato.getId().toString());
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
        if (prato.getImagem()!=null){
            pratoRepository.save(prato);
            System.out.println("Prato salvo");
        }

        return "redirect:/pratos/listagem";
    }


}
