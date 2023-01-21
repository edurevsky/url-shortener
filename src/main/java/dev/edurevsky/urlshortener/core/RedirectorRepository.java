package dev.edurevsky.urlshortener.core;

public interface RedirectorRepository {

    Redirector create(Redirector redirector);
    Redirector findBySlug(Slug slug);
    boolean slugAreadyExists(Slug slug);
    void deleteAllExpired();
}
