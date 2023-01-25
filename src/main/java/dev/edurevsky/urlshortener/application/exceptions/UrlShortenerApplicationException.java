package dev.edurevsky.urlshortener.application.exceptions;

public class UrlShortenerApplicationException extends RuntimeException {

    public UrlShortenerApplicationException() {
        super();
    }

    public UrlShortenerApplicationException(String message) {
        super(message);
    }

    public UrlShortenerApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UrlShortenerApplicationException(Throwable cause) {
        super(cause);
    }

    protected UrlShortenerApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
