package dev.edurevsky.urlshortener.web.requests;

import dev.edurevsky.urlshortener.application.commands.CreateRedirectorCommand;

public record NewRedirectorRequest(String url) implements CreateRedirectorCommand {
}
