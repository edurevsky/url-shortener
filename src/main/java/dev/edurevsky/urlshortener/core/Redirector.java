package dev.edurevsky.urlshortener.core;

import java.time.LocalDateTime;

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
}
