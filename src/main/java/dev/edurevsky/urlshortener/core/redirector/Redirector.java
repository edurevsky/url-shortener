package dev.edurevsky.urlshortener.core.redirector;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Redirector {

    private Slug slug;
    private URL redirectsTo;
    private LocalDateTime expiration;

    public Redirector() {

    }

    public Redirector(String fromUrl) {
        this.slug = new Slug();
        this.redirectsTo = new URL(fromUrl);
        this.expiration = LocalDateTime.now().plusHours(1);
    }

    public Redirector(Slug slug, String redirectsTo, LocalDateTime expiration) {
        this.slug = slug;
        this.redirectsTo = new URL(redirectsTo);
        this.expiration = expiration;
    }

    public String getSlug() {
        return slug.toString();
    }

    public String getRedirectsTo() {
        return redirectsTo.toString();
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(this.expiration);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Redirector that = (Redirector) o;
        return slug.equals(that.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slug, redirectsTo, expiration);
    }
}
