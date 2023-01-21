package dev.edurevsky.urlshortener.core;

import java.util.Random;

public final class Slug {

    public static final String ALLOWED_REGEX = "[a-z0-9]{5,10}";
    public static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyz1234567890";

    private String value;

    public Slug() {
        int min = 5;
        int max = 11;
        var sb = new StringBuilder();

        var random = new Random();
        var length = random.nextInt(max - min) + min;
        for (int i = 0; i < length; i++) {
            var index = random.nextInt(ALLOWED_CHARACTERS.length());
            char c = ALLOWED_CHARACTERS.charAt(index);
            sb.append(c);
        }

        this.setValue(sb.toString());
    }

    public Slug(String slug) {
        this.setValue(slug);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    private void setValue(String value) {
        if (!value.matches(ALLOWED_REGEX)) {
            throw new IllegalArgumentException("Value does not match the allowed regex.");
        }
        this.value = value;
    }
}
