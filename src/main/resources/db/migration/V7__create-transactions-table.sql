create table if not exists transactions
(
    id               serial constraint transaction_pk primary key,
    uid              varchar,
    from_card_id     varchar,
    from_account_id  INTEGER,
    to_card_id       varchar,
    to_account_id    varchar,
    amount           INTEGER,
    created_at       timestamp not null,
    updated_at       timestamp not null,
    foreign key (from_card_id) references cards(id),
    foreign key (from_account_id) references accounts(id),
    foreign key (to_card_id) references cards(id),
    foreign key (to_account_id) references accounts(id)
);