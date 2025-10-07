package br.senac.tads.dsw.apigerenciamentousuarios.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Configuração do Spring MVC para servir arquivos estáticos.
 * Esta classe configura o acesso aos arquivos de upload através de URLs.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        try {
            // Converte o caminho do diretório de uploads em um caminho absoluto
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();

            // Cria a URL do diretório de uploads (formato file:/// para Windows)
            String locationUri = "file:///" + uploadPath.toString().replace("\\", "/") + "/";

            // Configura o mapeamento /uploads/** para acessar os arquivos
            registry.addResourceHandler("/uploads/**")
                    .addResourceLocations(locationUri)
                    .setCachePeriod(3600); // Cache de 1 hora
        } catch (Exception e) {
            throw new RuntimeException("Erro ao configurar diretório de uploads: " + e.getMessage());
        }
    }

    @Bean
    public LocalValidatorFactoryBean getValidator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

}