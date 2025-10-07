package br.senac.tads.dsw.apigerenciamentousuarios.service;

import br.senac.tads.dsw.apigerenciamentousuarios.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Serviço responsável por gerenciar os usuários do sistema.
 * Neste exemplo simples, os dados são armazenados em memória.
 */
@Service
public class UsuarioService {

    // Simula um banco de dados em memória usando um Map
    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private Long proximoId = 1L;

    /**
     * Retorna todos os usuários cadastrados
     */
    public List<Usuario> buscarTodos() {
        return new ArrayList<>(usuarios.values());
    }

    /**
     * Busca um usuário pelo seu ID
     */
    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    /**
     * Salva um novo usuário
     */
    public Usuario salvar(Usuario usuario) {
        usuario.setId(proximoId);
        usuarios.put(proximoId, usuario);
        proximoId++;
        return usuario;
    }

    /**
     * Atualiza os dados de um usuário existente
     */
    public Optional<Usuario> atualizar(Long id, Usuario usuario) {
        if (usuarios.containsKey(id)) {
            usuario.setId(id);
            usuarios.put(id, usuario);
            return Optional.of(usuario);
        }
        return Optional.empty();
    }

    /**
     * Remove um usuário pelo seu ID
     */
    public boolean deletarPorId(Long id) {
        return usuarios.remove(id) != null;
    }
}