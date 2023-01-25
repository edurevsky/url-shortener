package dev.edurevsky.urlshortener.core;

public final class IllegalURLException extends UrlShortenerCoreException {

    private static final String MESSAGE = "Invalid or insecure URL.";

    public IllegalURLException() {
        super(MESSAGE);
    }
}
