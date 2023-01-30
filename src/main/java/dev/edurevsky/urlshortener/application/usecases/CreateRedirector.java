package dev.edurevsky.urlshortener.application.usecases;

import dev.edurevsky.urlshortener.application.commands.CreateRedirectorCommand;
import dev.edurevsky.urlshortener.core.redirector.Redirector;
import dev.edurevsky.urlshortener.core.redirector.RedirectorRepository;
import dev.edurevsky.urlshortener.core.redirector.Slug;

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
