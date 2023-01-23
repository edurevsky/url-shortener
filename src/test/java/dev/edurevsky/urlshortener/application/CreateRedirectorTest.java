package dev.edurevsky.urlshortener.application;

import dev.edurevsky.urlshortener.application.commands.CreateRedirectorCommand;
import dev.edurevsky.urlshortener.core.Redirector;
import dev.edurevsky.urlshortener.core.RedirectorRepository;
import dev.edurevsky.urlshortener.core.Slug;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateRedirectorTest {

    @Test
    void shouldCreateRedirectorWithoutAnyExistingSlug() {

        var repository = mock(RedirectorRepository.class);
        var createRedirector = new CreateRedirector(repository);

        var url = "https://youtube.com";
        CreateRedirectorCommand command = () -> url;

        var redirector = new Redirector(url);

        when(repository.create(any(Redirector.class)))
                .thenReturn(redirector);


        createRedirector.execute(command);


        verify(repository, times(1))
                .slugAreadyExists(any());

        verify(repository, times(1))
                .create(any());

    }

    @Test
    void shouldCreateRedirectorIfAtLeastOneSlugAlreadyExists() {
        var repository = mock(RedirectorRepository.class);
        var createRedirector = new CreateRedirector(repository);

        var url = "https://google.com";
        CreateRedirectorCommand command = () -> url;

        var redirector = new Redirector(url);

        when(repository.create(any(Redirector.class)))
                .thenReturn(redirector);

        when(repository.slugAreadyExists(any()))
                .thenReturn(true)
                .thenReturn(false);


        createRedirector.execute(command);


        verify(repository, times(2))
                .slugAreadyExists(any(Slug.class));

        verify(repository, times(1))
                .create(any(Redirector.class));
    }

    @Test
    void shouldThrowErrorIfUrlIsInvalid() {
        var repository = mock(RedirectorRepository.class);
        var createRedirector = new CreateRedirector(repository);

        var url = "";
        CreateRedirectorCommand command = () -> url;

        var expectedType = IllegalArgumentException.class;
        assertThrows(expectedType, () -> createRedirector.execute(command));

    }
}
