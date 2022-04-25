create table table_book
(
    book_id   serial not null
        primary key,
    author    varchar(255),
    genre     varchar(255),
    publisher varchar(255),
    title     varchar(255)
);