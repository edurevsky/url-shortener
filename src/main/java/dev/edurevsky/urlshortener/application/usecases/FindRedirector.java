package dev.edurevsky.urlshortener.application.usecases;

import dev.edurevsky.urlshortener.application.commands.FindRedirectorCommand;
import dev.edurevsky.urlshortener.application.exceptions.RedirectorNotFoundException;
import dev.edurevsky.urlshortener.core.redirector.Redirector;
import dev.edurevsky.urlshortener.core.redirector.RedirectorRepository;
import dev.edurevsky.urlshortener.core.redirector.Slug;

public final class FindRedirector extends UseCase<FindRedirectorCommand, Redirector> {

    private final RedirectorRepository redirectorRepository;

    public FindRedirector(final RedirectorRepository redirectorRepository) {
        this.redirectorRepository = redirectorRepository;
    }

    @Override
    public Redirector execute(final FindRedirectorCommand command) {
        var slug = new Slug(command.slug());

        var redirector = redirectorRepository.findBySlug(slug);

        if (redirector.isEmpty()) {
            throw RedirectorNotFoundException.from(slug);
        }

        return redirector.get();
    }
}
