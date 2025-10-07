package br.senac.sp.tads.dsw.exemplo.controller;

import br.senac.sp.tads.dsw.exemplo.model.Pessoa;
import br.senac.sp.tads.dsw.exemplo.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
public class PessoaRestController {

    private final PessoaService service;

    @GetMapping
    public List<Pessoa> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa pessoa) {
        service.adicionar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable int id, @RequestBody Pessoa pessoa) {
        service.listar().set(id, pessoa);
        return pessoa;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id) {
        service.listar().remove(id);
    }
}
