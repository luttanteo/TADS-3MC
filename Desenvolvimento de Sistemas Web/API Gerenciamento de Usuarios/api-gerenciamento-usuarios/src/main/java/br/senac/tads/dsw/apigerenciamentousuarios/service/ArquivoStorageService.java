package br.senac.tads.dsw.apigerenciamentousuarios.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

/**
 * Serviço responsável por gerenciar o upload de arquivos no sistema.
 * Os arquivos são salvos em um diretório específico configurado no application.properties.
 */
@Service
public class ArquivoStorageService {

    // Diretório onde os arquivos serão salvos
    private final Path diretorioUploads;

    /**
     * Construtor que inicializa o serviço configurando o diretório de uploads.
     * O caminho do diretório é lido do arquivo application.properties.
     */
    public ArquivoStorageService(@Value("${file.upload-dir}") String uploadDir) {
        try {
            // Converte o caminho em um objeto Path e normaliza
            this.diretorioUploads = Paths.get(uploadDir).toAbsolutePath().normalize();

            // Cria o diretório se não existir
            if (!Files.exists(diretorioUploads)) {
                Files.createDirectories(diretorioUploads);
            }

            // Verifica se tem permissão de escrita
            if (!Files.isWritable(diretorioUploads)) {
                throw new IOException("Sem permissão de escrita no diretório: " + diretorioUploads);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar diretório de upload: " + uploadDir, e);
        }
    }

    /**
     * Salva um arquivo enviado pelo usuário.
     *
     * @param arquivo     O arquivo enviado
     * @param nomeArquivo O nome que o arquivo terá ao ser salvo
     * @return O nome do arquivo salvo
     */
    public String salvarArquivo(MultipartFile arquivo, String nomeArquivo) {
        try {
            // Validações básicas
            if (arquivo == null || arquivo.isEmpty()) {
                throw new IllegalArgumentException("Arquivo vazio ou não fornecido");
            }
            if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome do arquivo não fornecido");
            }
            if (nomeArquivo.contains("..") || nomeArquivo.contains("/") || nomeArquivo.contains("\\")) {
                throw new IllegalArgumentException("Nome de arquivo inválido: " + nomeArquivo);
            }

            // Cria o caminho completo onde o arquivo será salvo
            Path destino = this.diretorioUploads.resolve(nomeArquivo).normalize();

            // Verifica se o destino está dentro do diretório de uploads (segurança)
            if (!destino.getParent().equals(this.diretorioUploads)) {
                throw new IllegalArgumentException("Não é permitido salvar arquivo fora do diretório de uploads");
            }

            // Salva o arquivo
            Files.copy(arquivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

            // Verifica se o arquivo foi salvo corretamente
            if (!Files.exists(destino)) {
                throw new IOException("Falha ao verificar se o arquivo foi criado");
            }

            return nomeArquivo;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar o arquivo: " + e.getMessage(), e);
        }
    }
}