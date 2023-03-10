package dev.edurevsky.urlshortener.core.redirector;

import java.util.Optional;

public interface RedirectorRepository {

    Redirector create(Redirector redirector);
    Optional<Redirector> findBySlug(Slug slug);
    boolean slugAreadyExists(Slug slug);
    void deleteAllExpired();
}
