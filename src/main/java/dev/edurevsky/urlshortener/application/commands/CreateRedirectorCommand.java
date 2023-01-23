package dev.edurevsky.urlshortener.application.commands;

public interface CreateRedirectorCommand extends Command {
    String url();
}
