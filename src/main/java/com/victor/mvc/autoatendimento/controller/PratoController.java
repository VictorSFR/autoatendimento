package com.victor.mvc.autoatendimento.controller;

import com.victor.mvc.autoatendimento.dto.PratoDto;
import com.victor.mvc.autoatendimento.dto.PratoDtoAdm;
import com.victor.mvc.autoatendimento.dto.RequisicaoSalvarPrato;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    //TODO refatorar método, deletar por ID
    @GetMapping("/deletar")
    public String deletarPrato(@RequestParam Long id){
        System.out.println("Recebi uma requisição para deletar um prato.");

        /*Prato prato = pratoRepository.findByNomePrato(nomePrato);
        System.out.println(prato.getNomePrato());*/
        pratoRepository.deleteById(id);

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

        pratoRepository.save(prato);
        return "redirect:/pratos/listagem";
    }
    //TODO método para editarPrato
    //TODO método para excluirPrato
    //TODO método para listarPrato

}
