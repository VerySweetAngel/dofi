--
-- skrypt do tworzenia struktury bazy danych
--

-- tabela uzytkowników
CREATE TABLE users(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT users_pk PRIMARY KEY,
    login VARCHAR(15) NOT NULL CONSTRAINT users_unique_login UNIQUE,
    password VARCHAR(15) NOT NULL,
    real_name VARCHAR(30),
    email VARCHAR(30),
    is_admin SMALLINT DEFAULT 0
);
CREATE INDEX users_login_index ON users(login);
INSERT INTO users (login, password, is_admin) VALUES ('admin', 'admin', 1);
INSERT INTO users (login, password, is_admin) VALUES ('tester', 'tester', 0);