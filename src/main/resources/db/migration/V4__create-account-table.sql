CREATE TABLE IF NOT EXISTS accounts
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    uid varchar(40) not null,
    iban varchar(255) not null,
    balance INTEGER,
    person_id INTEGER,
    FOREIGN KEY (person_id) REFERENCES persons(id)
);