package br.senac.sp.tads.dsw.exemplo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome obrigatório")
    private String sobrenome;
}
