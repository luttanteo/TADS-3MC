package br.senac.tads.dsw.apigerenciamentousuarios.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Classe que representa um usuário no sistema.
 * Usando a anotação @Data do Lombok para gerar automaticamente getters, setters, toString, etc.
 */
@Data
public class Usuario {

    // Identificador único do usuário
    private Long id;

    // Nome do usuário - obrigatório e deve ter entre 3 e 100 caracteres
    @NotBlank(message = "{usuario.nome.notblank}")
    @Size(min = 3, max = 100, message = "{usuario.nome.size}")
    private String nome;

    // Apelido do usuário - obrigatório e máximo 64 caracteres
    @NotBlank(message = "{usuario.apelido.notblank}")
    @Size(max = 64, message = "{usuario.apelido.size}")
    private String apelido;

    // Email do usuário - obrigatório e deve ser um email válido
    @NotBlank(message = "{usuario.email.notblank}")
    @Email(message = "{usuario.email.valid}")
    private String email;

    // Data de nascimento - obrigatória e deve ser uma data no passado
    @NotNull(message = "{usuario.datanascimento.notnull}")
    @Past(message = "{usuario.datanascimento.past}")
    private LocalDate dataNascimento;

    // Caminho para a foto de perfil do usuário
    private String caminhoFotoPerfil;
}
