package dev.edurevsky.urlshortener.core;

import java.util.Objects;

public final class URL {

    public static final String SECURE_URL = "https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()!@:%_+.~#?&/=]*)";

    private String value;

    public URL(String fromUrl) {
        this.setValue(fromUrl);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    private void setValue(String value) {
        if (!value.matches(SECURE_URL)) {
            throw new IllegalURLException();
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        URL url = (URL) o;
        return value.equals(url.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
