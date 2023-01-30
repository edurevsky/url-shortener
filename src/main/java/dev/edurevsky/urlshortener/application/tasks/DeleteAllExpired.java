package dev.edurevsky.urlshortener.application.tasks;

import dev.edurevsky.urlshortener.application.commands.NoCommand;
import dev.edurevsky.urlshortener.core.redirector.RedirectorRepository;

public final class DeleteAllExpired extends Task {

    private final RedirectorRepository redirectorRepository;

    public DeleteAllExpired(RedirectorRepository redirectorRepository) {
        this.redirectorRepository = redirectorRepository;
    }

    @Override
    public Void execute(NoCommand ignored) {
        redirectorRepository.deleteAllExpired();
        return null;
    }
}
