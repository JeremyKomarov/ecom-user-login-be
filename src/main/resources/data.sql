INSERT INTO users (username, password, active, roles, permissions) VALUES
('dan', '1234', 1, 'USER', ''),
('alon', '1235', 1, 'ADMIN', '');

INSERT INTO profile (user_id, first_name, last_name, email, phone, address) VALUES
(1, 'Dan', 'Cohen', 'dan@example.com', '050-1234567', 'Tel Aviv');
