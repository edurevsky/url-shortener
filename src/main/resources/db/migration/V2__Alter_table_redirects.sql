ALTER TABLE redirects
    MODIFY COLUMN `created_at` DATETIME NOT NULL,
    MODIFY COLUMN `expires_at` DATETIME NOT NULL;
