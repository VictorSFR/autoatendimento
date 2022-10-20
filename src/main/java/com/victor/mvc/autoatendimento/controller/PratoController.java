package com.victor.mvc.autoatendimento.controller;

import com.victor.mvc.autoatendimento.dto.PratoDto;
import com.victor.mvc.autoatendimento.dto.RequisicaoSalvarPrato;
import com.victor.mvc.autoatendimento.model.Prato;
import com.victor.mvc.autoatendimento.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
@RequestMapping("pratos")
public class PratoController {
    @Autowired
    private PratoRepository pratoRepository;

    @GetMapping("novoprato")
    public String novoPrato(RequisicaoSalvarPrato requisicaoSalvarPrato){
        return "prato/novoprato";
    }
    @PostMapping(value = "salvarprato",consumes = MULTIPART_FORM_DATA_VALUE)
    public String salvarPrato(@Valid RequisicaoSalvarPrato requisicaoSalvarPrato, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "prato/novoprato";
        }

        Prato prato = requisicaoSalvarPrato.toPrato();

        pratoRepository.save(prato);
        return "/home";
    }

}
