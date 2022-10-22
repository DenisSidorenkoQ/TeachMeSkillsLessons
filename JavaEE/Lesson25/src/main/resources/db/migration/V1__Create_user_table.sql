create table "user"
(
    user_id  serial primary key,
    login    varchar not null unique,
    password varchar not null
);

INSERT INTO "user" (login, password) VALUES ('Denis', '1234'), ('Dasha', '1111'), ('German', '2211'), ('Alex', 'ffff');


