create table if not exists cards
(
    id               serial constraint card_pk primary key,
    uid              varchar,
    pan              varchar,
    account_id       INTEGER,
    expiration_date  DATE,
    pin              varchar,
    cvv              varchar,
    status           varchar,
    person_id        INTEGER,
    created_at       timestamp not null,
    updated_at       timestamp not null,
    foreign key (account_id) references accounts(id),
    foreign key (person_id) references persons(id)
);