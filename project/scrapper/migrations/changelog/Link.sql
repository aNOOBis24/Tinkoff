--liquibase formatted sql

--changeset aNOOBis24:create-link-table-1
CREATE TABLE "link" (
                        id bigserial PRIMARY KEY,
                        url text UNIQUE NOT NULL,
                        updated_at timestamp NOT NULL
);

--rollback DROP TABLE "link";