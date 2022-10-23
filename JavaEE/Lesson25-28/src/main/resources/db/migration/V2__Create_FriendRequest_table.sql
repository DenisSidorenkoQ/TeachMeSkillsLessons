create table friend_request
(
    request_id   serial primary key,
    sender_id    integer,
    recipient_id integer
);

INSERT INTO "friend_request" (sender_id, recipient_id) VALUES (2, 1), (3, 1), (4, 1);

