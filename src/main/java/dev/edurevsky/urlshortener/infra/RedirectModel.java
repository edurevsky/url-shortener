package dev.edurevsky.urlshortener.infra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;

@Table(name = "redirects")
@Entity(name = "Redirects")
public class RedirectModel implements Persistable<String> {

    @Id
    @Column(
            name = "slug",
            length = 10
    )
    private String slug;
    @Column(
            name = "url",
            columnDefinition = "VARCHAR(2048) NOT NULL",
            length = 2048
    )
    private String url;
    @Column(name = "created_at")
    private LocalDateTime creationDate;
    @Column(name = "expires_at")
    private LocalDateTime expirationDate;

    public RedirectModel() {

    }

    @Override
    public String getId() {
        return slug;
    }

    @Override
    public boolean isNew() {
        return true;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
