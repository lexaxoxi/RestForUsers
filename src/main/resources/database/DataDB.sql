INSERT INTO roles (role_name) VALUES ('admin');
INSERT INTO roles(role_name) VALUES ('operator');
INSERT INTO roles(role_name) VALUES ('analyst');
INSERT INTO roles(role_name) VALUES ('boss');

INSERT INTO users (user_name, user_login, user_password) VALUES ('alex', 'superAlex', 'passworD8!');
INSERT INTO users (user_name, user_login, user_password)  VALUES ('marat', 'SosoMarat', '123Qwerty');
INSERT INTO users (user_name, user_login, user_password)  VALUES ('kate', 'WowKate', 'Qwerty123');

INSERT INTO user_roles (role_id, user_name) VALUES (1, 'superAlex');
INSERT INTO user_roles (role_id, user_name) VALUES (4, 'superAlex');
INSERT INTO user_roles (role_id, user_name) VALUES (2, 'SosoMarat');
INSERT INTO user_roles (role_id, user_name) VALUES (3, 'SosoMarat');
INSERT INTO user_roles (role_id, user_name) VALUES (1, 'WowKate');