package dev.edurevsky.urlshortener.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaRedirectRepository extends JpaRepository<RedirectModel, String> {

    boolean existsBySlug(String slug);
    @Modifying
    @Query(value = "DELETE FROM Redirects r WHERE r.expirationDate < LOCAL_DATETIME")
    void removeAllExpired();
}
