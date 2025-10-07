package br.senac.tads.dsw.apigerenciamentousuarios.controller;

import br.senac.tads.dsw.apigerenciamentousuarios.model.Usuario;
import br.senac.tads.dsw.apigerenciamentousuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por gerenciar as requisições relacionadas a usuários.
 * Define os endpoints da API REST para operações CRUD (Create, Read, Update, Delete).
 */
@RestController // Marca esta classe como um controller REST
@RequestMapping("/usuarios") // Todos os endpoints começarão com /usuarios
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Injeção de dependência pelo construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Cria um novo usuário
     * POST /usuarios
     */
    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.salvar(usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }

    /**
     * Retorna a lista de todos os usuários
     * GET /usuarios
     */
    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.buscarTodos();
    }

    /**
     * Busca um usuário pelo ID
     * GET /usuarios/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Atualiza os dados de um usuário existente
     * PUT /usuarios/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        return usuarioService.atualizar(id, usuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um usuário pelo ID
     * DELETE /usuarios/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (usuarioService.deletarPorId(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
