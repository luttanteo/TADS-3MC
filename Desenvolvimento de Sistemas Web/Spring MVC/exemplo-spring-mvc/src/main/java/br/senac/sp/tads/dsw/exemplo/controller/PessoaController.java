package br.senac.sp.tads.dsw.exemplo.controller;

import br.senac.sp.tads.dsw.exemplo.model.Pessoa;
import br.senac.sp.tads.dsw.exemplo.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        model.addAttribute("lista", service.listar());
        return "index"; //vai procurar index.html em resources/templates
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("pessoa") Pessoa pessoa,
                         BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("lista", service.listar());
            return "index";
        }
        service.adicionar(pessoa);
        return "redirect:/"; //redireciona para a lista
    }
}
