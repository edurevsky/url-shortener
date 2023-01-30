package dev.edurevsky.urlshortener.web;

import dev.edurevsky.urlshortener.application.usecases.CreateRedirector;
import dev.edurevsky.urlshortener.application.usecases.FindRedirector;
import dev.edurevsky.urlshortener.core.redirector.Redirector;
import dev.edurevsky.urlshortener.web.requests.NewRedirectorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/")
public class RedirectorController {

    private final CreateRedirector createRedirector;
    private final FindRedirector findRedirector;

    public RedirectorController(
            CreateRedirector createRedirector,
            FindRedirector findRedirector
    ) {
        this.createRedirector = createRedirector;
        this.findRedirector = findRedirector;
    }

    @GetMapping("{slug}")
    public RedirectView redirect(@PathVariable("slug") String slug) {
        var redirector = this.findRedirector.execute(() -> slug);

        var url = redirector.getRedirectsTo();

        return new RedirectView(url);
    }

    @PostMapping
    public ResponseEntity<Redirector> create(@RequestBody NewRedirectorRequest request, UriComponentsBuilder uriBuilder) {
        var redirector = this.createRedirector.execute(request);
        var location = uriBuilder.path("/{slug}").build(redirector.getSlug());
        return created(location).body(redirector);
    }
}
