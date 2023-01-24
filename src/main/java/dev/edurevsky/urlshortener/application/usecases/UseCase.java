package dev.edurevsky.urlshortener.application.usecases;

import dev.edurevsky.urlshortener.application.commands.Command;

public abstract class UseCase<C extends Command, T> {

    public abstract T execute(C command);
}
