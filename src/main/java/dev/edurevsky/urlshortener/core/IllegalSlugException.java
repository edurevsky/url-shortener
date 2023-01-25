package dev.edurevsky.urlshortener.core;

public final class IllegalSlugException extends UrlShortenerCoreException {

    private static final String MESSAGE = "Slug length should be between 5 and 10 characters.";

    public IllegalSlugException() {
        super(MESSAGE);
    }
}
