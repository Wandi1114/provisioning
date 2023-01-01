DROP TABLE IF EXISTS provisioning_db.ordering;
CREATE TABLE IF NOT EXISTS provisioning_db.ordering (
   id serial PRIMARY KEY,
   name varchar(50)
);