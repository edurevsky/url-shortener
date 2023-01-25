package dev.edurevsky.urlshortener.infra;

import dev.edurevsky.urlshortener.core.Redirector;
import dev.edurevsky.urlshortener.core.RedirectorRepository;
import dev.edurevsky.urlshortener.core.Slug;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class JpaRedirectorRepositoryImpl implements RedirectorRepository {

    private final JpaRedirectRepository jpaRedirectRepository;

    public JpaRedirectorRepositoryImpl(JpaRedirectRepository jpaRedirectRepository) {
        this.jpaRedirectRepository = jpaRedirectRepository;
    }

    @Override
    public Redirector create(Redirector redirector) {
        var model = this.toModel(redirector);
        this.jpaRedirectRepository.save(model);
        return redirector;
    }

    @Override
    public boolean slugAreadyExists(Slug slug) {
        return this.jpaRedirectRepository.existsBySlug(slug.toString());
    }

    @Override
    @Transactional
    public void deleteAllExpired() {
        this.jpaRedirectRepository.removeAllExpired();
    }

    @Override
    public Optional<Redirector> findBySlug(Slug slug) {
        var model = this.jpaRedirectRepository.findById(slug.toString());

        return model.map(this::toDomain);
    }

    private RedirectModel toModel(Redirector redirector) {
        var model = new RedirectModel();

        model.setSlug(redirector.getSlug());
        model.setUrl(redirector.getRedirectsTo());
        model.setExpirationDate(redirector.getExpiration());
        model.setCreationDate(LocalDateTime.now());
        return model;
    }

    private Redirector toDomain(RedirectModel model) {
        var slug = new Slug(model.getSlug());
        var url = model.getUrl();
        var expiration = model.getExpirationDate();

        return new Redirector(slug, url, expiration);
    }
}
