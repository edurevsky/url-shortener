package dev.edurevsky.urlshortener.application.usecases;

import dev.edurevsky.urlshortener.application.commands.FindRedirectorCommand;
import dev.edurevsky.urlshortener.application.exceptions.RedirectorNotFoundException;
import dev.edurevsky.urlshortener.core.Redirector;
import dev.edurevsky.urlshortener.core.RedirectorRepository;
import dev.edurevsky.urlshortener.core.Slug;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindRedirectorTest {

    @Test
    void shouldThrowExceptionWhenRedirectorIsNotFound() {

        var redirectorRepository = mock(RedirectorRepository.class);
        var findRedirector = new FindRedirector(redirectorRepository);

        when(redirectorRepository.findBySlug(any(Slug.class)))
                .thenReturn(Optional.empty());


        var slug = "xsf2l";
        FindRedirectorCommand command = () -> slug;


        var expectedType = RedirectorNotFoundException.class;
        assertThrows(expectedType, () -> findRedirector.execute(command));

    }

    @Test
    void shouldNotThrowException() {

        var redirectorRepository = mock(RedirectorRepository.class);
        var findRedirector = new FindRedirector(redirectorRepository);

        var url = "https://google.com";
        var redirector = new Redirector(url);

        when(redirectorRepository.findBySlug(any(Slug.class)))
                .thenReturn(Optional.of(redirector));


        var slug = "slf3oa2";
        FindRedirectorCommand command = () -> slug;


        var message = RedirectorNotFoundException.from(new Slug(slug)).getMessage();
        assertDoesNotThrow(() -> findRedirector.execute(command), message);

    }
}