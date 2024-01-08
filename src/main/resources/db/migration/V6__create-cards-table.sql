create table if not exists cards
(
    id               serial constraint card_pk primary key,
    uid              varchar,
    account_id       INTEGER,
    pan              varchar,
    pin              varchar,
    cvv              varchar,
    expiration_date  DATE,
    CARD_STATUS      varchar,
    person_id        INTEGER,
    created_at       timestamp not null,
    updated_at       timestamp not null,
    foreign key (account_id) references accounts(id),
    foreign key (person_id) references persons(id)
);