package dev.edurevsky.urlshortener.core;

public class UrlShortenerCoreException extends RuntimeException {

    public UrlShortenerCoreException() {
        super();
    }

    public UrlShortenerCoreException(String message) {
        super(message);
    }

    public UrlShortenerCoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public UrlShortenerCoreException(Throwable cause) {
        super(cause);
    }

    protected UrlShortenerCoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
