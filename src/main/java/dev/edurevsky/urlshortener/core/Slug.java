package dev.edurevsky.urlshortener.core;

import java.util.Random;

public final class Slug {

    private final String value;

    public Slug() {
        int min = 5;
        int max = 10;
        var sb = new StringBuilder();

        var random = new Random();
        var length = random.nextInt(max - min) + min + 1;
        for (int i = 0; i < length; i++) {
            var index = random.nextInt(Characters.ALLOWED.length());
            char c = Characters.ALLOWED.charAt(index);
            sb.append(c);
        }

        this.value = sb.toString();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
