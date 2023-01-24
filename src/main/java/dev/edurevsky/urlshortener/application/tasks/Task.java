package dev.edurevsky.urlshortener.application.tasks;

import dev.edurevsky.urlshortener.application.commands.NoCommand;
import dev.edurevsky.urlshortener.application.usecases.UseCase;

public abstract class Task extends UseCase<NoCommand, Void> {

    @Override
    public abstract Void execute(NoCommand ignored);
}
