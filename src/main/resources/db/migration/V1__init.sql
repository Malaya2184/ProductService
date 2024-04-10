CREATE TABLE categories
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE jt_instructors
(
    id              BIGINT NOT NULL,
    speciallization VARCHAR(255) NULL,
    CONSTRAINT pk_jt_instructors PRIMARY KEY (id)
);

CREATE TABLE jt_mentors
(
    id BIGINT NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_mentors PRIMARY KEY (id)
);

CREATE TABLE jt_tas
(
    user_id            BIGINT NOT NULL,
    number_of_sessions INT    NOT NULL,
    avgrating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_tas PRIMARY KEY (user_id)
);

CREATE TABLE jt_users
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_jt_users PRIMARY KEY (id)
);

CREATE TABLE msc_instructors
(
    id              BIGINT NOT NULL,
    name            VARCHAR(255) NULL,
    email           VARCHAR(255) NULL,
    password        VARCHAR(255) NULL,
    speciallization VARCHAR(255) NULL,
    CONSTRAINT pk_msc_instructors PRIMARY KEY (id)
);

CREATE TABLE msc_mentors
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_msc_mentors PRIMARY KEY (id)
);

CREATE TABLE msc_tas
(
    id                 BIGINT NOT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    number_of_sessions INT    NOT NULL,
    avgrating DOUBLE NOT NULL,
    CONSTRAINT pk_msc_tas PRIMARY KEY (id)
);

CREATE TABLE products
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    title         VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id   BIGINT NULL,
    `description` VARCHAR(255) NULL,
    image         VARCHAR(255) NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE st_users
(
    id                 BIGINT NOT NULL,
    dtype              VARCHAR(31) NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    speciallization    VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    number_of_sessions INT    NOT NULL,
    CONSTRAINT pk_st_users PRIMARY KEY (id)
);

CREATE TABLE tbc_instructors
(
    id              BIGINT NOT NULL,
    name            VARCHAR(255) NULL,
    email           VARCHAR(255) NULL,
    password        VARCHAR(255) NULL,
    speciallization VARCHAR(255) NULL,
    CONSTRAINT pk_tbc_instructors PRIMARY KEY (id)
);

CREATE TABLE tbc_mentors
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tbc_mentors PRIMARY KEY (id)
);

CREATE TABLE tbc_tas
(
    id                 BIGINT NOT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    number_of_sessions INT    NOT NULL,
    avgrating DOUBLE NOT NULL,
    CONSTRAINT pk_tbc_tas PRIMARY KEY (id)
);

CREATE TABLE tbc_users
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tbc_users PRIMARY KEY (id)
);

ALTER TABLE jt_instructors
    ADD CONSTRAINT FK_JT_INSTRUCTORS_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE jt_mentors
    ADD CONSTRAINT FK_JT_MENTORS_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE jt_tas
    ADD CONSTRAINT FK_JT_TAS_ON_USERID FOREIGN KEY (user_id) REFERENCES jt_users (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);