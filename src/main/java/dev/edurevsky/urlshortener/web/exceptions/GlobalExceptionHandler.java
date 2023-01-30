package dev.edurevsky.urlshortener.web.exceptions;

import dev.edurevsky.urlshortener.application.exceptions.RedirectorNotFoundException;
import dev.edurevsky.urlshortener.core.redirector.UrlShortenerCoreException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(RedirectorNotFoundException.class)
    public ErrorResponse handleRedirectorNotFoundException(RedirectorNotFoundException e) {
        var timestamp = LocalDateTime.now();
        var status = NOT_FOUND.value();
        var error = NOT_FOUND.name();
        var message = e.getMessage();

        return new ErrorResponse(timestamp, status, error, message);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(UrlShortenerCoreException.class)
    public ErrorResponse handleBadSlugException(UrlShortenerCoreException e) {
        var timestamp = LocalDateTime.now();
        var status = BAD_REQUEST.value();
        var error = BAD_REQUEST.name();
        var message = e.getMessage();

        return new ErrorResponse(timestamp, status, error, message);
    }
}
