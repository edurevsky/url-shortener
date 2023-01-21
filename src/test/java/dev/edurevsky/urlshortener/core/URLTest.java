package dev.edurevsky.urlshortener.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLTest {

    @Test
    void shouldNotCreateURL() {

        var expectedType = IllegalArgumentException.class;

        var url1 = "http://";
        var url2 = "";
        var url3 = "https://a";

        assertThrows(expectedType, () -> new URL(url1));
        assertThrows(expectedType, () -> new URL(url2));
        assertThrows(expectedType, () -> new URL(url3));

    }
}
