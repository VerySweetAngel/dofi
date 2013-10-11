--
-- skrypt do usuwania struktury bazy danych
--

-- tabela zestawień
DROP INDEX juxtapositions_name_index;
DROP TABLE juxtapositions;

-- tabela operacji i asocjacji z tagami
DROP TABLE operation_tags;
DROP INDEX operations_creations_date_index;
DROP INDEX operations_category_index;
DROP TABLE operations;

-- tabela tagów i ich wiązań
DROP INDEX taglinks_word_index;
DROP TABLE taglinks;
DROP INDEX tags_tagname_index;
DROP TABLE tags;

-- tabela uzytkowników
DROP INDEX users_login_index;
DROP TABLE users;

-- schemat
DROP SCHEMA APP RESTRICT;
