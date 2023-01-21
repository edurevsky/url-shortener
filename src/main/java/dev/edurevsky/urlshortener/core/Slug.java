package dev.edurevsky.urlshortener.core;

import java.util.Random;

public final class Slug {

    private String value;

    public Slug() {
        int min = 5;
        int max = 11;
        var sb = new StringBuilder();

        var random = new Random();
        var length = random.nextInt(max - min) + min;
        for (int i = 0; i < length; i++) {
            var index = random.nextInt(Characters.ALLOWED.length());
            char c = Characters.ALLOWED.charAt(index);
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
        if (!value.matches(Characters.ALLOWED_REGEX)) {
            throw new IllegalArgumentException("Value does not match the allowed regex.");
        }
        this.value = value;
    }
}
