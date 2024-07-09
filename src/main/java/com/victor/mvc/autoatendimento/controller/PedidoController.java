package com.victor.mvc.autoatendimento.controller;
import com.victor.mvc.autoatendimento.dto.*;
import com.victor.mvc.autoatendimento.model.Prato;
import com.victor.mvc.autoatendimento.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PedidoController {

    @GetMapping("novopedido")
    public String mostrarPedido(){

        return "teste";
    }
}
