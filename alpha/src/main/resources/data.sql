INSERT INTO city_unit (id, name, address, visitors) VALUES (1, 'Valhallabadet', 'Badgatan 3', 201);
INSERT INTO city_unit (id, name, address, visitors) VALUES (2, 'Ullevi', 'Idrottsgatan 5', 873);
INSERT INTO city_unit (id, name, address, visitors) VALUES (3, 'Fritidsgård', 'Fritidsgårdsgatan 1', 57);

INSERT INTO category (name, city_unit_id) VALUES ('Simhall', 1);
INSERT INTO category (name, city_unit_id) VALUES ('Simskola', 1);
INSERT INTO category (name, city_unit_id) VALUES ('Friidrott', 2);
INSERT INTO category (name, city_unit_id) VALUES ('Fotboll', 2);
INSERT INTO category (name, city_unit_id) VALUES ('konsert', 2);
INSERT INTO category (name, city_unit_id) VALUES ('Fritidsgård', 3);