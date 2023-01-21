package dev.edurevsky.urlshortener.core;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class SlugTest {

    @Test
    void shouldCreateSlugsBetween5and10Characters() {

        for (int i = 0; i < 100; i++) {

            var slug = new AtomicReference<Slug>();

            assertDoesNotThrow(
                    () -> slug.set(new Slug()),
                    "Value does not match the allowed regex."
            );

            assertTrue(slug.get().getValue().matches(Slug.ALLOWED_REGEX));

        }
    }
}
