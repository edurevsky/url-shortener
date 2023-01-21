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

    @Test
    void shouldNotCreateSlug() {

        var expectedType = IllegalArgumentException.class;

        assertThrows(expectedType, () -> new Slug(""));
        assertThrows(expectedType, () -> new Slug("-"));
        assertThrows(expectedType, () -> new Slug("++++++"));
        assertThrows(expectedType, () -> new Slug("$"));
        assertThrows(expectedType, () -> new Slug("a"));
        assertThrows(expectedType, () -> new Slug("a7"));
        assertThrows(expectedType, () -> new Slug("a9e"));
        assertThrows(expectedType, () -> new Slug("a9ea"));
        assertThrows(expectedType, () -> new Slug("a9ea2iepsaw"));
        assertThrows(expectedType, () -> new Slug("fh792q3fhql"));
        assertThrows(expectedType, () -> new Slug("11111111111"));
        assertThrows(expectedType, () -> new Slug("auhwf97q2h4fahsfl"));

    }

    @Test
    void shouldCreateSlug() {

        var message = "Value does not match the allowed regex.";

        assertDoesNotThrow(() -> new Slug("abcde"), message);
        assertDoesNotThrow(() -> new Slug("ab34da2"), message);
        assertDoesNotThrow(() -> new Slug("aiwj8ei2am"), message);

    }
}
