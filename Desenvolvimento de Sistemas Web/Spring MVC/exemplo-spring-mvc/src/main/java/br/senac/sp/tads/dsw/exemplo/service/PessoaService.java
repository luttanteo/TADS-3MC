package br.senac.sp.tads.dsw.exemplo.service;

import br.senac.sp.tads.dsw.exemplo.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PessoaService {

    private final List<Pessoa> lista = new CopyOnWriteArrayList<>();

    public List<Pessoa> listar() {
        return lista;
    }

    public void adicionar(Pessoa p) {
        lista.add(p);
    }
}
