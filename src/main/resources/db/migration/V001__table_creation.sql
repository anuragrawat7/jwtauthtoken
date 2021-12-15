create table jwt_auth_flyway(
    id binary(255),
    email_id varchar(255),
    created_at datetime(6),
    password varchar(255),
    PRIMARY KEY(id)
);