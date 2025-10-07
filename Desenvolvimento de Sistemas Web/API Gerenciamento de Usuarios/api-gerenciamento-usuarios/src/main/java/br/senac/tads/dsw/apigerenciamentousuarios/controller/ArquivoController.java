package br.senac.tads.dsw.apigerenciamentousuarios.controller;

import br.senac.tads.dsw.apigerenciamentousuarios.model.Usuario;
import br.senac.tads.dsw.apigerenciamentousuarios.service.ArquivoStorageService;
import br.senac.tads.dsw.apigerenciamentousuarios.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

/**
 * Controller responsável por gerenciar o upload de arquivos.
 * Neste exemplo, é usado para upload de fotos de perfil dos usuários.
 */
@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

    private final ArquivoStorageService arquivoStorageService;
    private final UsuarioService usuarioService;

    public ArquivoController(ArquivoStorageService arquivoStorageService, UsuarioService usuarioService) {
        this.arquivoStorageService = arquivoStorageService;
        this.usuarioService = usuarioService;
    }

    /**
     * Endpoint para upload da foto de perfil de um usuário
     * POST /arquivos/upload/{usuarioId}
     *
     * @param usuarioId ID do usuário
     * @param arquivo   Arquivo de imagem enviado no formulário
     * @return URL da foto salva
     */
    @PostMapping("/upload/{usuarioId}")
    public ResponseEntity<String> uploadFotoPerfil(
            @PathVariable Long usuarioId,
            @RequestParam("arquivo") MultipartFile arquivo) {

        try {
            // Verifica se o arquivo foi fornecido
            if (arquivo == null || arquivo.isEmpty()) {
                return ResponseEntity.badRequest().body("Arquivo não fornecido");
            }

            // Verifica se o usuário existe
            Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(usuarioId);
            if (usuarioOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            // Cria um nome único para o arquivo usando o ID do usuário
            String nomeArquivo = usuarioId + "_" + arquivo.getOriginalFilename();

            // Salva o arquivo
            arquivoStorageService.salvarArquivo(arquivo, nomeArquivo);

            // Atualiza o usuário com o caminho da foto
            Usuario usuario = usuarioOpt.get();
            String urlArquivo = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/uploads/")
                    .path(nomeArquivo)
                    .toUriString();

            usuario.setCaminhoFotoPerfil(urlArquivo);
            usuarioService.atualizar(usuarioId, usuario);

            return ResponseEntity.ok(urlArquivo);

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Erro ao fazer upload do arquivo: " + e.getMessage());
        }
    }
}