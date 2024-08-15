package com.victor.autoatendimento.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller
public class PedidoController {

    @GetMapping("novopedido")
    public String mostrarPedido(){

        return "teste";
    }
}
