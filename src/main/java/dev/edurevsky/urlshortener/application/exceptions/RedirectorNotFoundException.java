package dev.edurevsky.urlshortener.application.exceptions;

import dev.edurevsky.urlshortener.core.redirector.Slug;

public final class RedirectorNotFoundException extends UrlShortenerApplicationException {

    private static final String MESSAGE = "Redirector with slug '%s' not found.";

    private RedirectorNotFoundException(Slug slug) {
        super(MESSAGE.formatted(slug));
    }

    public static RedirectorNotFoundException from(Slug slug) {
        return new RedirectorNotFoundException(slug);
    }
}
