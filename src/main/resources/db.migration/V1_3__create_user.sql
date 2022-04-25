create table table_user
(
    user_id           serial not null
        primary key,
    first_name   varchar(255),
    gender       varchar(255),
    member_since timestamp,
    member_till  timestamp,
    name         varchar(255)
);