package dev.edurevsky.urlshortener.infra;

import dev.edurevsky.urlshortener.application.usecases.CreateRedirector;
import dev.edurevsky.urlshortener.application.tasks.DeleteAllExpired;
import dev.edurevsky.urlshortener.application.usecases.FindRedirector;
import dev.edurevsky.urlshortener.core.RedirectorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public RedirectorRepository redirectorRepository(JpaRedirectRepository jpaRedirectRepository) {
        return new JpaRedirectorRepositoryImpl(jpaRedirectRepository);
    }

    @Bean
    public CreateRedirector createRedirector(final RedirectorRepository redirectorRepository) {
        return new CreateRedirector(redirectorRepository);
    }

    @Bean
    public FindRedirector findRedirector(final RedirectorRepository redirectorRepository) {
        return new FindRedirector(redirectorRepository);
    }

    @Bean
    public DeleteAllExpired deleteAllExpired(final RedirectorRepository redirectorRepository) {
        return new DeleteAllExpired(redirectorRepository);
    }
}
