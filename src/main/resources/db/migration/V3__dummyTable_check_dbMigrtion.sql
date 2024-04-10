CREATE TABLE dummmy_table
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    created_at  datetime NULL,
    updated_at  datetime NULL,
    dummy_title VARCHAR(255) NULL,
    CONSTRAINT pk_dummmy_table PRIMARY KEY (id)
);