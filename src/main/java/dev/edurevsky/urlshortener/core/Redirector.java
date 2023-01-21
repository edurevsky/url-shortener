package dev.edurevsky.urlshortener.core;

import java.time.LocalDateTime;

public final class Redirector {

    private Slug slug;
    private String redirectsTo;
    private LocalDateTime expiration;

    public Redirector() {

    }

    public Redirector(String fromUrl) {
        this.slug = new Slug();
        this.redirectsTo = fromUrl;
        this.expiration = LocalDateTime.now().plusHours(1);
    }

    public Redirector(Slug slug, String redirectsTo, LocalDateTime expiration) {
        this.slug = slug;
        this.redirectsTo = redirectsTo;
        this.expiration = expiration;
    }

    public String getSlug() {
        return slug.toString();
    }

    public String getRedirectsTo() {
        return redirectsTo;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(this.expiration);
    }
}
