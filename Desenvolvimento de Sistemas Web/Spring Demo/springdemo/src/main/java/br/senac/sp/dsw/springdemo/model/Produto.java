package br.senac.sp.dsw.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {
    private String nome;
    private double preco;
}
