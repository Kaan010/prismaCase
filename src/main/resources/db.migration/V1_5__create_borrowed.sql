create table table_borrowed
(
    borrowed_id   serial
        primary key,
    borrowed_from timestamp,
    borrowed_to   timestamp,
    book_name          varchar(255),
    borrower_name      varchar(255)
);