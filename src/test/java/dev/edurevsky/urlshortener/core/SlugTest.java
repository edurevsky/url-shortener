package dev.edurevsky.urlshortener.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlugTest {

    @Test
    void shouldCreateSlugsBetween5and10Characters() {

        for (int i = 0; i < 100; i++) {

            var slug = new Slug();

            assertTrue(slug.getValue().matches(Characters.ALLOWED_REGEX));

        }
    }
}