DROP TABLE user_roles;
DROP TABLE users;
DROP TABLE roles;

CREATE TABLE IF NOT EXISTS roles
(
    role_id   SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    user_name     VARCHAR(50)             NOT NULL,
    user_login    VARCHAR(50) PRIMARY KEY NOT NULL,
    user_password VARCHAR(20)             NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles
(
    role_id SERIAL NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    CONSTRAINT fk1_user_roles FOREIGN KEY (role_id) REFERENCES roles (role_id),
    CONSTRAINT fk2_user_roles FOREIGN KEY (user_name) REFERENCES users (user_login)
)