CREATE TABLE redirects
(
    `slug`       VARCHAR(10) PRIMARY KEY NOT NULL,
    `url`        VARCHAR(2048)           NOT NULL,
    `created_at` DATE                    NOT NULL,
    `expires_at` DATE                    NOT NULL,
);
