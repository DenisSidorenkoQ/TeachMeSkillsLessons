CREATE TABLE users
(
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);

    INSERT INTO users (login, password) VALUES ('Denis', '1234');
