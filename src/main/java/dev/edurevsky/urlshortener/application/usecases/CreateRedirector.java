package dev.edurevsky.urlshortener.application.usecases;

import dev.edurevsky.urlshortener.application.commands.CreateRedirectorCommand;
import dev.edurevsky.urlshortener.core.Redirector;
import dev.edurevsky.urlshortener.core.RedirectorRepository;
import dev.edurevsky.urlshortener.core.Slug;

public final class CreateRedirector extends UseCase<CreateRedirectorCommand, Redirector> {

    private final RedirectorRepository redirectorRepository;

    public CreateRedirector(final RedirectorRepository redirectorRepository) {
        this.redirectorRepository = redirectorRepository;
    }

    @Override
    public Redirector execute(final CreateRedirectorCommand command) {
        var url = command.url();

        Redirector redirector;
        do {
            redirector = new Redirector(url);
        } while (redirectorRepository.slugAreadyExists(Slug.from(redirector)));

        return redirectorRepository.create(redirector);
    }
}
