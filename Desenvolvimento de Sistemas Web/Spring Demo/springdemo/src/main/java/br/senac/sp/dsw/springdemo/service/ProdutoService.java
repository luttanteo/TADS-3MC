package br.senac.sp.dsw.springdemo.service;

import br.senac.sp.dsw.springdemo.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    public List<Produto> listar() {
        return List.of(
            new Produto("Caderno",20.0),
                new Produto("Caneta", 5.0)
                );
    }
}
