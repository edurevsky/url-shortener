package dev.edurevsky.urlshortener.application.commands;

public interface FindRedirectorCommand extends Command {
    String slug();
}
