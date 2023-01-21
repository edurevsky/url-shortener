package dev.edurevsky.urlshortener.core;

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
            throw new IllegalArgumentException("Value does not match as an valid or secure URL.");
        }
        this.value = value;
    }
}
