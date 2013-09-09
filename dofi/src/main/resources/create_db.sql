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

-- tabela tagów i ich wiązań
CREATE TABLE tags (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT tags_pk PRIMARY KEY,
    tagname VARCHAR(50) NOT NULL CONSTRAINT tags_unique_tagname UNIQUE,
    category SMALLINT DEFAULT 0, -- debry 10.5 nie mają BOOLEAN
    parent INTEGER,
    FOREIGN KEY (parent) REFERENCES tags(id)
);
CREATE INDEX tags_tagname_index ON tags(tagname);

CREATE TABLE taglinks(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT taglinks_pk PRIMARY KEY,
    word VARCHAR(50) NOT NULL,
    tag INTEGER NOT NULL,
    FOREIGN KEY (tag) REFERENCES tags(id)
);
CREATE INDEX taglinks_word_index ON taglinks(word);

-- tabela operacji i asocjacji z tagami
CREATE TABLE operations(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT operations_pk PRIMARY KEY,
    creations_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    operator INTEGER NOT NULL,
    creator INTEGER NOT NULL,
    category INTEGER NOT NULL,
    "value" INTEGER NOT NULL,
    FOREIGN KEY (category) REFERENCES users(id)
);
CREATE INDEX operations_creations_date_index ON operations(creations_date);
CREATE INDEX operations_category_index ON operations(category);

CREATE TABLE operation_tags(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT operation_tags_pk PRIMARY KEY,
    tag INTEGER NOT NULL,
    "operation" INTEGER NOT NULL,
    FOREIGN KEY (tag) REFERENCES tags(id),
    FOREIGN KEY ("operation") REFERENCES operations(id)
);

-- tabela zestawień
CREATE TABLE juxtapositions(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT juxtapositions_pk PRIMARY KEY,
    tag INTEGER NOT NULL,
    "name" VARCHAR(50) NOT NULL CONSTRAINT juxtapositions_unique_name UNIQUE,
    FOREIGN KEY (tag) REFERENCES tags(id)
);
CREATE INDEX juxtapositions_name_index ON juxtapositions("name");