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
    CONSTRAINT tags_parent_fk FOREIGN KEY (parent) REFERENCES tags(id)
);
CREATE INDEX tags_tagname_index ON tags(tagname);

-- insert dla kategorii z bilansu
    
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'zasilenie', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'oszczędności', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'techniczne', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'rachunki / podatki', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'żywność', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'AGD', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'kosmetyki', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'hobby', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'prezent', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'transport', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'zdrowie', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'artkuły biurowe', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'kradzież/zguba', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'nauka', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'odzież', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'słodycze', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'rozrywka', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'inne', 1);
INSERT INTO TAGS (TAGNAME, CATEGORY) VALUES ( 'pożyczka', 1);


CREATE TABLE taglinks(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT taglinks_pk PRIMARY KEY,
    word VARCHAR(50) NOT NULL,
    tag INTEGER NOT NULL,
    CONSTRAINT taglinks_tag_fk FOREIGN KEY (tag) REFERENCES tags(id)
);
CREATE INDEX taglinks_word_index ON taglinks(word);

-- tabela operacji i asocjacji z tagami
CREATE TABLE operations(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT operations_pk PRIMARY KEY,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    operation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    operator INTEGER NOT NULL,
    creator INTEGER NOT NULL,
    category INTEGER NOT NULL,
    value INTEGER NOT NULL,
    CONSTRAINT operations_operator_fk FOREIGN KEY (operator) REFERENCES users(id),
    CONSTRAINT operations_creator_fk FOREIGN KEY (creator) REFERENCES users(id),
    CONSTRAINT operations_category_fk FOREIGN KEY (category) REFERENCES tags(id)
);
CREATE INDEX operations_creations_date_index ON operations(creation_date);
CREATE INDEX operations_category_index ON operations(category);

CREATE TABLE operation_tags(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT operation_tags_pk PRIMARY KEY,
    tag INTEGER NOT NULL,
    operation INTEGER NOT NULL,
    CONSTRAINT operation_tags_tag_fk FOREIGN KEY (tag) REFERENCES tags(id),
    CONSTRAINT operation_tags_operation_fk FOREIGN KEY (operation) REFERENCES operations(id)
);

-- tabela zestawień
CREATE TABLE juxtapositions(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT juxtapositions_pk PRIMARY KEY,
    tag INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL CONSTRAINT juxtapositions_unique_name UNIQUE,
    CONSTRAINT juxtapositions_tag_fk FOREIGN KEY (tag) REFERENCES tags(id)
);
CREATE INDEX juxtapositions_name_index ON juxtapositions(name);