package br.senac.sp.dsw.springdemo.controller;

import br.senac.sp.dsw.springdemo.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService service;

    @GetMapping("/produtos")
    public String listar(Model model) {
        model.addAttribute("produtos", service.listar());
        return "produtos";
    }
}
