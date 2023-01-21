package dev.edurevsky.urlshortener.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RedirectorTest {

    @Test
    void returnsTrueWhenIsExpired() {

        var slug = new Slug();
        var url = "https://google.com";
        var datetime = LocalDateTime.now().minusHours(1L);

        var redirector = new Redirector(slug, url, datetime);

        assertTrue(redirector.isExpired());

    }

    @Test
    void returnsFalseWhenNotIsExpired() {

        var slug = new Slug();
        var url = "https://google.com";
        var datetime = LocalDateTime.now().plusHours(1L);

        var redirector = new Redirector(slug, url, datetime);

        assertFalse(redirector.isExpired());

    }

}
