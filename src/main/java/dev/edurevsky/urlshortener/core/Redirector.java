package dev.edurevsky.urlshortener.core;

public final class Redirector {

    private Slug slug;
    private String redirectsTo;

    public Redirector(String fromUrl) {
        this.slug = new Slug();
        this.redirectsTo = fromUrl;
    }

    public String getSlug() {
        return slug.toString();
    }

    public String getRedirectsTo() {
        return redirectsTo;
    }
}
