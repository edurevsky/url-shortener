package dev.edurevsky.urlshortener.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface JpaRedirectRepository extends JpaRepository<RedirectModel, String> {

    boolean existsBySlug(String slug);
    void removeAllByExpirationDateBefore(LocalDateTime before);
}
